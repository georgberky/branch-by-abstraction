package bba.business;

import java.util.List;

public interface Store {
    Data loadByName(String name);
    List<Data> loadAll();
}
