package bba.business;

import java.util.List;

public interface Store {
    Item loadByName(String name);
    List<Item> loadAll();
}
