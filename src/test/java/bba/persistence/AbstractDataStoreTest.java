package bba.persistence;

import bba.business.Data;
import bba.business.DataStore;
import bba.business.Olfactory;
import bba.business.Quality;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

public abstract class AbstractDataStoreTest {
    protected DataStore store;

    @Test
    void loadAll() {
        List<Data> all = store.loadAll();

        assertSoftly(softly -> {
            softly.assertThat(all)
                .extracting(Data::name)
                .containsExactlyInAnyOrder("firstName", "secondName", "thirdName");

            softly.assertThat(all)
                .extracting(Data::quality)
                .containsOnly(Quality.BAD);

            softly.assertThat(all)
                .extracting(Data::olfactory)
                .containsOnly(Olfactory.SMELLY);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = { "someName", "someOtherName", "yetAnotherName" })
    void loadByName(String name) {
        Data retrieved = store.loadByName(name);

        assertThat(retrieved)
            .extracting(Data::name, Data::quality, Data::olfactory)
            .containsExactly(name, Quality.BAD, Olfactory.SMELLY);
    }
}
