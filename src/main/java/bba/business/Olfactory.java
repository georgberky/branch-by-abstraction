package bba.business;

public enum Olfactory {
    PLEASANT, UGLY;

    public static Olfactory of(String name) {
        switch (name) {
            case "🌸️":
                return PLEASANT;
            case "💩":
                return UGLY;
            default:
                throw new IllegalArgumentException("No such olfactory: " + name);
        }
    }
}
