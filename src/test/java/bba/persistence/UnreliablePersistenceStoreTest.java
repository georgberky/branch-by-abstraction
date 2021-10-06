package bba.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

class UnreliablePersistenceStoreTest {
    private UnreliablePersistenceStore store;

    @BeforeEach
    void setUp() {
        store = new UnreliablePersistenceStore();
    }

    @Test
    void loadAll() {
        List<Map<String, Object>> all = store.loadAll();

        assertSoftly(softly -> {
            softly.assertThat(all)
                .extracting(m -> m.get("name"))
                .containsExactlyInAnyOrder("firstName", "secondName", "thirdName");

            softly.assertThat(all)
                .extracting(m -> LocalDateTime.parse((String) m.get("created")))
                .allSatisfy(d -> d.isBefore(now()));

            softly.assertThat(all)
                .extracting(m -> m.get("quality"))
                .containsOnly("🤮");

            softly.assertThat(all)
                .extracting(m -> m.get("olfactory"))
                .containsOnly("💩");
        });
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
