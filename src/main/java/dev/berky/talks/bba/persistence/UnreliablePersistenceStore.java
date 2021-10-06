package dev.berky.talks.bba.persistence;

import java.util.List;
import java.util.Map;

import static dev.berky.talks.bba.persistence.Fail.failRandomly;

public class UnreliablePersistenceStore {

    public Map<String, Object> loadByName(String name) {
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
