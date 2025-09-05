# QuickNotes Backend – PATCH & PUT + Kafka Toggle

**Changes:**

* PATCH & PUT endpoints in `NoteController` with Optional handling.
* Kafka publishing toggle using `@ConditionalOnProperty("kafka.enabled")`.
* Local testing without Kafka possible.

**Tested:**

* PATCH with partial updates & nulls.
* PUT full update.
* Kafka disabled locally works fine.

**Branch:** `feature/patch-put-kafka`
**Merge into:** `main` after review.
