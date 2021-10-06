package dev.berky.talks.bba.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(strings = { "someName", "someOtherName", "yetAnotherName" })
    void loadByName(String name) {
        Map<String, Object> retrieved = store.loadByName(name);

        assertThat(retrieved)
            .containsEntry("name", name)
            .containsEntry("quality", "🤮")
            .containsEntry("olfactory", "💩")
            .hasEntrySatisfying("created", v -> LocalDateTime.parse((String) v)
                .isBefore(now()));
    }
}
