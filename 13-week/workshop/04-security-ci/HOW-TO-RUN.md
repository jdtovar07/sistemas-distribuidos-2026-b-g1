# CP4 - How to run the negative test

Covers story 1, "[security] Redis only accepts authenticated clients", acceptance criterion 1:
a client that connects without a password and sends `PING` must be rejected.

The test is `RedisNoAuthRejectedTest.java` (JDK only, same image as `opti-infra`: `redis:7.4.9-alpine`).

## Run locally
```bash
# 1. Redis WITH a password (the state the story asks for)
docker run --rm -d --name redis-authz -p 6379:6379 redis:7.4.9-alpine redis-server --requirepass ci-test-password

# 2. The negative test
java 04-security-ci/RedisNoAuthRejectedTest.java 127.0.0.1 6379

# 3. Stop Redis
docker stop redis-authz
```
Expected: `PASS  unauthenticated client is rejected`.
Against today's `opti-infra` Redis (no password) the same test prints `FAIL`: that is the threat S of the STRIDE table.

## Validate the workflow
```bash
actionlint security.yml
```

## CP8 - real output (run on my machine, 2026-10-30, Docker with redis:7.4.9-alpine, JDK 25)

Redis started WITH a password (`--requirepass ci-test-password`):
```
reply to unauthenticated PING: -NOAUTH Authentication required.
PASS  unauthenticated client is rejected (opti-workflow state store, port 6379)
```

Redis started WITHOUT a password (the state of `opti-infra` today, threat S):
```
reply to unauthenticated PING: +PONG
FAIL  Redis answered an unauthenticated client: +PONG
```

`actionlint 1.7.12` on `security.yml`: first run reported one shellcheck warning (SC2034, loop variable `i` unused in the Redis wait loop). I changed it to `_` and the second run printed nothing, exit code 0.

Not run: the GitHub Actions workflow itself (the secret scan and the dependency audit); only the negative test and the YAML check were run locally.
