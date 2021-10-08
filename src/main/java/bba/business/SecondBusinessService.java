package bba.business;

import bba.persistence.UnreliablePersistenceStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class SecondBusinessService {
    private static final Logger LOG = LoggerFactory.getLogger(SecondBusinessService.class);

    private final UnreliablePersistenceStore store;

    public SecondBusinessService(UnreliablePersistenceStore store) {
        this.store = store;

        LOG.info("Created: {}", this.getClass().getSimpleName());
    }

    public void doSomething() {
        LOG.info("Doing something second!");
        Map<String, Object> dataFromStore = store.loadByName("name2");

        LOG.info("Found data with name: {}", dataFromStore.get("name"));
        LOG.info("Data has quality: {}", dataFromStore.get("olfactory"));
    }
}
