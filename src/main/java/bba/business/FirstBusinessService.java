package bba.business;

import bba.persistence.UnreliablePersistenceStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class FirstBusinessService {
    private static final Logger LOG = LoggerFactory.getLogger(FirstBusinessService.class);

    private final Store store;

    public FirstBusinessService(Store store) {
        this.store = store;

        LOG.info("Created: {}", this.getClass().getSimpleName());
    }

    public void doSomething() {
        LOG.info("Doing something first!");
        Data dataFromStore = store.loadByName("name1");

        LOG.info("Found data with name: {}", dataFromStore.name());
        LOG.info("Data has quality: {}", dataFromStore.quality());
    }
}
