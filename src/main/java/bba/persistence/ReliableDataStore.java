package bba.persistence;

import bba.business.Data;
import bba.business.DataStore;
import bba.business.Olfactory;
import bba.business.Quality;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static java.util.Collections.unmodifiableList;

public class ReliableDataStore implements DataStore {
    private static final Logger LOG = LoggerFactory.getLogger(ReliableDataStore.class);

    @Override
    public Data loadByName(String name) {
        LOG.info("Serving data for {}", name);

        return new Data(name, Quality.BAD, Olfactory.SMELLY);
    }

    @Override
    public List<Data> loadAll() {
        return unmodifiableList(loadAll());
    }
}
