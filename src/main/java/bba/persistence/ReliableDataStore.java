package bba.persistence;

import bba.business.Data;
import bba.business.DataStore;
import bba.business.Olfactory;
import bba.business.Quality;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReliableDataStore implements DataStore {
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
        return Stream.of("firstName", "secondName", "thirdName")
            .map(this::loadByName)
            .collect(Collectors.toList());
    }
}
