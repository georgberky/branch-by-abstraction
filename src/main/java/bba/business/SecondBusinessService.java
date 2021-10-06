package bba.business;

import bba.persistence.UnreliablePersistenceStore;

public class SecondBusinessService {
    private final UnreliablePersistenceStore store;

    public SecondBusinessService(UnreliablePersistenceStore store) {
        this.store = store;
    }
}
