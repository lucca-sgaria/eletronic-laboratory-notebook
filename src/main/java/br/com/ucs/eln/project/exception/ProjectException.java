package br.com.ucs.eln.project.exception;

public class ProjectException extends Exception {
    private final ProjectExceptionKey key;

    public ProjectException(ProjectExceptionKey key) {
        this.key = key;
    }

    public ProjectExceptionKey getKey() {
        return key;
    }

    @Override
    public String toString() {
        return key.toString();
    }
}
