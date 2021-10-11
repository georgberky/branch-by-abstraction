package bba.business;

import java.util.Arrays;
import java.util.Objects;

public enum Olfactory {
    SMELLY("💩"),
    ROSY("🌹"),
    CHERRY("🌸");

    private String representation;

    Olfactory(String representation) {

        this.representation = representation;
    }

    public static Olfactory of(String olfactory) {
        return Arrays.stream(Olfactory.values())
            .filter(o -> Objects.equals(o.representation, olfactory))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("no such value: " + olfactory));
    }
}
