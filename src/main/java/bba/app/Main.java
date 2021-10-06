package bba.app;

import bba.business.FirstBusinessService;
import bba.persistence.UnreliablePersistenceStore;
import bba.web.HttpApi;

public class Main {
    public static void main(String[] args) {
        var store = new UnreliablePersistenceStore();

        var firstService = new FirstBusinessService(store);
        var secondService = new FirstBusinessService(store);

        var http = new HttpApi(firstService, secondService);
        http.startApplication();
    }
}
