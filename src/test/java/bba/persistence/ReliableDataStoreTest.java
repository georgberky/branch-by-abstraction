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

class ReliableDataStoreTest extends AbstractDataStoreTest {

    private ReliableDataStore reliableStore;

    @BeforeEach
    protected void setUp() {
        store = new ReliableDataStore();
        reliableStore = (ReliableDataStore) store;
    }

    @Test
    void specificTest() {
        //set up specific precondition, e.g. train mocks for exception

        reliableStore.loadAll();

        //something specific to assert, e.g. exception handling
    }
}
