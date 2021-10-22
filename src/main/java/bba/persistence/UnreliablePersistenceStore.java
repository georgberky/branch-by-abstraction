package bba.persistence;

import bba.business.Item;
import bba.business.Olfactory;
import bba.business.Quality;
import bba.business.Store;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

import static bba.persistence.Fail.failRandomly;

public class UnreliablePersistenceStore implements Store {
    private static final Logger LOG = LoggerFactory.getLogger(UnreliablePersistenceStore.class);

    public UnreliablePersistenceStore() {
        LOG.info("Created: {}", this.getClass().getSimpleName());
    }

    @Override
    public Item loadByName(String name) {
        var item = loadByName_legacy(name);

        return new Item((
            String)item.get("name"),
            Quality.of((String) item.get("quality")),
            Olfactory.of((String)item.get("olfactory")));
    }

    @Override
    public List<Item> loadAll() {
        return List.of(
            loadByName("firstName"),
            loadByName("secondName"),
            loadByName("thirdName")
        );
    }

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

    public List<Map<String, Object>> loadAll_legacy() {
        return List.of(
            loadByName_legacy("firstName"),
            loadByName_legacy("secondName"),
            loadByName_legacy("thirdName")
        );
    }
}
