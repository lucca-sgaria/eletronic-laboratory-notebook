package br.com.ucs.eln.experiment.exception;

public class ExperimentException extends Exception {
    private final ExperimentExceptionKey key;

    public ExperimentException(ExperimentExceptionKey key) {
        this.key = key;
    }

    public ExperimentExceptionKey getKey() {
        return key;
    }

    @Override
    public String toString() {
        return key.toString();
    }
}
