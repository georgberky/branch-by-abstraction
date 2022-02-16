package bba.persistence;

import bba.business.Data;
import bba.business.DataStore;
import bba.business.Olfactory;
import bba.business.Quality;
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

class UnreliablePersistenceStoreTest extends DataStoreTest {
    private UnreliablePersistenceStore unreliablePersistenceStore;

    public UnreliablePersistenceStoreTest() {
        super(new UnreliablePersistenceStore());
    }

    @BeforeEach
    void setUp() {
        unreliablePersistenceStore = new UnreliablePersistenceStore();
    }

    @Test
    void loadAll_legacy() {
        List<Map<String, Object>> all = unreliablePersistenceStore.loadAll_legacy();

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
    void loadByName_legacy(String name) {
        Map<String, Object> retrieved = unreliablePersistenceStore.loadByName_legacy(name);

        assertThat(retrieved)
            .containsEntry("name", name)
            .containsEntry("quality", "🤮")
            .containsEntry("olfactory", "💩")
            .hasEntrySatisfying("created", v -> LocalDateTime.parse((String) v)
                .isBefore(now()));
    }
}
