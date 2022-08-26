package br.com.ucs.eln.group.exception;

public class GroupException extends Exception {
    private final GroupExceptionKey key;

    public GroupException(GroupExceptionKey key) {
        this.key = key;
    }

    public GroupExceptionKey getKey() {
        return key;
    }

    @Override
    public String toString() {
        return key.toString();
    }
}
