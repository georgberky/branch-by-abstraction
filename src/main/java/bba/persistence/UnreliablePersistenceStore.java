package bba.persistence;

import bba.business.Data;
import bba.business.DataStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static bba.persistence.Fail.failRandomly;

public class UnreliablePersistenceStore implements DataStore {
    private static final Logger LOG = LoggerFactory.getLogger(UnreliablePersistenceStore.class);

    public UnreliablePersistenceStore() {
        LOG.info("Created: {}", this.getClass().getSimpleName());
    }

    @Override
    public Data loadByName(String name) {
        return new Data(loadByName_legacy(name));
    }

    @Deprecated
    public Map<String, Object> loadByName_legacy(String name) {
        LOG.info("Serving data for {}", name);

        failRandomly(() -> new DatabaseException("database locked!"));

        return Map.of(
            "name", name,
            "created", "2007-12-03T10:15:30",
            "quality", "🤮",
            "olfactory", "💩"
        );
    }

    @Override
    public List<Data> loadAll() {
        return loadAll_legacy().stream()
            .map(Data::new)
            .collect(Collectors.toList());
    }

    @Deprecated
    public List<Map<String, Object>> loadAll_legacy() {
        return List.of(
            loadByName_legacy("firstName"),
            loadByName_legacy("secondName"),
            loadByName_legacy("thirdName")
        );
    }
}
