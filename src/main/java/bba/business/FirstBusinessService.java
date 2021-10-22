package bba.business;

import bba.persistence.UnreliablePersistenceStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class FirstBusinessService {
    private static final Logger LOG = LoggerFactory.getLogger(FirstBusinessService.class);

    private final UnreliablePersistenceStore store;

    public FirstBusinessService(UnreliablePersistenceStore store) {
        this.store = store;

        LOG.info("Created: {}", this.getClass().getSimpleName());
    }

    public void doSomething() {
        LOG.info("Doing something first!");
        Map<String, Object> dataFromStore = store.loadByName_legacy("name1");

        LOG.info("Found data with name: {}", dataFromStore.get("name"));
        LOG.info("Data has quality: {}", dataFromStore.get("quality"));
    }
}
