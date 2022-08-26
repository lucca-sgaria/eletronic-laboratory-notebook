package br.com.ucs.eln.user.exception;

public class UserException extends Exception {
    private final UserExceptionKey key;

    public UserException(UserExceptionKey key) {
        this.key = key;
    }

    public UserExceptionKey getKey() {
        return key;
    }

    @Override
    public String toString() {
        return key.toString();
    }
}
