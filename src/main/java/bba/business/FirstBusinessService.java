package bba.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstBusinessService {
    private static final Logger LOG = LoggerFactory.getLogger(FirstBusinessService.class);

    private final DataStore store;

    public FirstBusinessService(DataStore store) {
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
