package dev.berky.talks.bba.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.assertj.core.api.Assertions.assertThat;

class UnreliablePersistenceStoreTest {
    private UnreliablePersistenceStore store;

    @BeforeEach
    void setUp() {
        store = new UnreliablePersistenceStore();
    }

    @Test
    void loadByName() {
        Map<String, Object> retrieved = store.loadByName("someName");

        assertThat(retrieved)
            .containsEntry("name", "someName")
            .containsEntry("quality", "🤮")
            .containsEntry("olfactory", "💩")
            .hasEntrySatisfying("created", v -> LocalDateTime.parse((String) v)
                .isBefore(now()));
    }
}
