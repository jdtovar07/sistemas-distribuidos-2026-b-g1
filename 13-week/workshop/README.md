# Week 13 workshop - Threat modeling and the security backlog (OptiView)

Boundary: `opti-workflow` -> Redis (saga state store). Journey: the `place-order` saga.
Why: Redis holds the state of every saga and today it accepts any client on the network without a password, so it is the boundary with the biggest gap between what it protects and how it is protected.

<!-- CONFIG-START -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- DOCS_REPO: https://github.com/code-corhuila/opti-docs
- BOUNDARY: opti-workflow to Redis (saga state store)
- CLAIM_ISSUE: TODO (URL of the "Threat model:" issue once opened)
- REFLECTION_DOC: TODO (URL of "W13 Reflection - Juan Diego Tovar Rodriguez")
- LIBRARY_BOOK: Tanenbaum, A. S. and Van Steen, M., Sistemas distribuidos: principios y paradigmas, 2nd ed., Pearson Prentice Hall, year TODO: 2007 or 2008, read it on the copyright page of the copy, call number TODO (photos show barcode 0008588, Biblioteca Antonio Farid Campos Polanía)
- LIBRARY_RECORD_TIME: TODO (time of the library record)
- STORIES: TODO (three issue URLs, added in CP3)
<!-- CONFIG-END -->

## Index
| File | Checkpoint |
|---|---|
| `01-attack-surface.md` | CP1 |
| `04-security-ci/` | CP4 (workflow, negative test, HOW-TO-RUN.md) |
| `opti-docs/05-architecture/security/stride-jdtovar07.md` | CP2 (Pull Request) |
