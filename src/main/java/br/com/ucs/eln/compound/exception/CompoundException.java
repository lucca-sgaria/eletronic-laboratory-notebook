package br.com.ucs.eln.compound.exception;

public class CompoundException extends Exception {
    private final CompoundExceptionKey key;

    public CompoundException(CompoundExceptionKey key) {
        this.key = key;
    }

    public CompoundExceptionKey getKey() {
        return key;
    }

    @Override
    public String toString() {
        return key.toString();
    }
}
