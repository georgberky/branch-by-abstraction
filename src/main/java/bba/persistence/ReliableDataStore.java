package bba.persistence;

import bba.business.Data;
import bba.business.DataStore;
import bba.business.Olfactory;
import bba.business.Quality;

import java.util.List;

public class ReliableDataStore implements DataStore {
    @Override
    public Data loadByName(String name) {
        return new Data(name, Quality.BAD, Olfactory.SMELLY);
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
