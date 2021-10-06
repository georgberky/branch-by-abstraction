package bba.business;

import bba.persistence.UnreliablePersistenceStore;

public class FirstBusinessService {
    private final UnreliablePersistenceStore store;

    public FirstBusinessService(UnreliablePersistenceStore store) {
        this.store = store;
    }
}
