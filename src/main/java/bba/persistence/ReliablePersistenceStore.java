package bba.persistence;

import bba.business.Data;
import bba.business.Olfactory;
import bba.business.Quality;
import bba.business.Store;

import java.util.List;

public class ReliablePersistenceStore implements Store {
    @Override
    public Data loadByName(String name) {
        return new Data(
            name,
            Quality.BAD,
            Olfactory.SMELLY
        );
    }

    @Override
    public List<Data> loadAll() {
        return List.of(
            loadByName("firstName"),
            loadByName("secondName"),
            loadByName("thirdName")
        );
    }
}
