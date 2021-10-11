package bba.app;

import bba.business.DataStore;
import bba.business.FirstBusinessService;
import bba.business.SecondBusinessService;
import bba.persistence.ReliableDataStore;
import bba.persistence.UnreliablePersistenceStore;
import bba.web.HttpApi;
import bba.web.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String... args) {
        LOG.info("Booting application");

        var persistenceSwitch = System.getProperty("feature.persistence");
        DataStore store = createPersistence(persistenceSwitch);

        var firstService = new FirstBusinessService(store);
        var secondService = new SecondBusinessService(store);

        var http = new HttpApi(firstService, secondService);
        http.startServing();
        var response = http.handleRequest(new Request());

        LOG.info("Response: {}", response);
    }

    private static DataStore createPersistence(String property) {
        if("reliable".equals(property)) {
            return new ReliableDataStore();
        }

        return new UnreliablePersistenceStore();
    }
}
