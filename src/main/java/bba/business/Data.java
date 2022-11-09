package bba.business;

import java.util.Map;

public final class Data {
    private final String name;
    private final Quality quality;
    private final Olfactory olfactory;

    public Data(Map<String, Object> data) {
        this.name = (String) data.get("name");
        this.quality =  Quality.of((String) data.get("quality"));
        this.olfactory =  Olfactory.of((String) data.get("olfactory"));
    }

    public Data(String name, Quality quality, Olfactory olfactory) {
        this.name = name;
        this.quality = quality;
        this.olfactory = olfactory;
    }

    public String name() {
        return name;
    }

    public Quality quality() {
        return quality;
    }

    public Olfactory olfactory() {
        return olfactory;
    }
}
