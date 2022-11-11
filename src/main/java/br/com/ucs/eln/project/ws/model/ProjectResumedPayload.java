package br.com.ucs.eln.project.ws.model;

import java.io.Serializable;

public class ProjectResumedPayload implements Serializable {
    private long id;
    private String number;

    public ProjectResumedPayload() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
