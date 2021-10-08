package bba.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

import static bba.persistence.Fail.failRandomly;

public class UnreliablePersistenceStore {
    private static final Logger LOG = LoggerFactory.getLogger(UnreliablePersistenceStore.class);

    public UnreliablePersistenceStore() {
        LOG.info("Created: {}", this.getClass().getSimpleName());
    }

    public Map<String, Object> loadByName(String name) {
        LOG.info("Serving data for {}", name);

        failRandomly(() -> new DatabaseException("database locked!"));

        return Map.of(
            "name", name,
            "created", "2007-12-03T10:15:30",
            "quality", "🤮",
            "olfactory", "💩"
        );
    }

    public List<Map<String, Object>> loadAll() {
        return List.of(
            loadByName("firstName"),
            loadByName("secondName"),
            loadByName("thirdName")
        );
    }
}
