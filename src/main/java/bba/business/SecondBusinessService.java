package bba.business;

import bba.persistence.UnreliablePersistenceStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class SecondBusinessService {
    private static final Logger LOG = LoggerFactory.getLogger(SecondBusinessService.class);

    private final DataStore store;

    public SecondBusinessService(DataStore store) {
        this.store = store;

        LOG.info("Created: {}", this.getClass().getSimpleName());
    }

    public void doSomething() {
        LOG.info("Doing something second!");
        Data dataFromStore = store.loadByName("name2");

        LOG.info("Found data with name: {}", dataFromStore.name());
        LOG.info("Data has quality: {}", dataFromStore.olfactory());
    }
}
