package bba.business;

import java.util.Arrays;
import java.util.Objects;

public enum Quality {
    GOOD("☀️"),
    FAIR("🙂"),
    BAD("🤮");

    private final String representation;

    Quality(String representation) {
        this.representation = representation;
    }

    public static Quality of(String quality) {
        return Arrays.stream(Quality.values())
            .filter(q -> Objects.equals(q.representation, quality))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("no such value: " + quality));
    }
}
