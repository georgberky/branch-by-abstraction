package bba.business;

import java.util.Map;

public final class Data {
    private final Map<String, Object> data;

    @Deprecated
    public Data(Map<String, Object> data) {
        this.data = Map.copyOf(data);
    }

    public String name() {
        return (String) data.get("name");
    }

    public Quality quality() {
        return Quality.of((String) data.get("quality"));
    }

    public Olfactory olfactory() {
        return Olfactory.of((String) data.get("olfactory"));
    }
}
