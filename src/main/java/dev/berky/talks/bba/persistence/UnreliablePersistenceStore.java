package dev.berky.talks.bba.persistence;

import java.util.Map;

public class UnreliablePersistenceStore {
    public Map<String, Object> loadByName(String name) {
        return Map.of(
            "name", "someName",
            "created", "2007-12-03T10:15:30",
            "quality", "🤮",
            "olfactory", "💩"
        );
    }
}
