package bba.business;

import java.util.Objects;

public class Item {
    private final String name;
    private final Quality quality;
    private final Olfactory olfactory;

    public Item(String name, Quality quality, Olfactory olfactory) {
        this.name = name;
        this.quality = quality;
        this.olfactory = olfactory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return name.equals(item.name) &&
            quality == item.quality &&
            olfactory.equals(item.olfactory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quality, olfactory);
    }

    @Override
    public String toString() {
        return "Item{" +
            "name='" + name + '\'' +
            ", quality=" + quality +
            ", olfactory=" + olfactory +
            '}';
    }
}
