import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * Negative authorization test for the opti-workflow to Redis boundary (story 1: "Redis only accepts
 * authenticated clients"). It speaks the Redis protocol directly, so it needs only the JDK.
 *
 * Run: java RedisNoAuthRejectedTest.java <host> <port>
 * Expected against a Redis started with --requirepass: the PING without credentials is answered with -NOAUTH.
 */
public class RedisNoAuthRejectedTest {

    public static void main(String[] args) throws Exception {
        String host = args.length > 0 ? args[0] : "127.0.0.1";
        int port = args.length > 1 ? Integer.parseInt(args[1]) : 6379;

        String reply = sendWithoutCredentials(host, port, "*1\r\n$4\r\nPING\r\n");
        System.out.println("reply to unauthenticated PING: " + reply.trim());

        if (reply.startsWith("-NOAUTH") || reply.startsWith("-WRONGPASS")) {
            System.out.println("PASS  unauthenticated client is rejected (opti-workflow state store, port " + port + ")");
            return;
        }
        System.out.println("FAIL  Redis answered an unauthenticated client: " + reply.trim());
        System.exit(1);
    }

    private static String sendWithoutCredentials(String host, int port, String command) throws Exception {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), 2000);
            socket.setSoTimeout(2000);
            OutputStream out = socket.getOutputStream();
            out.write(command.getBytes(StandardCharsets.UTF_8));
            out.flush();
            InputStream in = socket.getInputStream();
            byte[] buffer = new byte[256];
            int read = in.read(buffer);
            return read < 0 ? "" : new String(buffer, 0, read, StandardCharsets.UTF_8);
        }
    }
}
