package bba.business;

public enum Quality {
    GOOD, BAD;

    public static Quality of(String name) {
        switch(name) {
            case "☀️":
                return GOOD;
            case "🤮":
                return BAD;
            default:
                throw new IllegalArgumentException("No such quality: " + name);
        }
    }
}
