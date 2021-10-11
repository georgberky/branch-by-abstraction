package bba.business;

import java.util.List;

public interface DataStore {
    Data loadByName(String name);
    List<Data> loadAll();
}
