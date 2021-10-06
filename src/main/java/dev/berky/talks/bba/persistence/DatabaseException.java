package dev.berky.talks.bba.persistence;

public class DatabaseException extends RuntimeException {
    public DatabaseException(String message) {
        super("💩: " + message);
    }
}
