package br.com.ucs.eln.experiment.ws.model;

import java.io.Serializable;
import java.util.Arrays;

public class ExperimentResumedPayload implements Serializable {
    private long id;
    private String number;
    private String name;

    public ExperimentResumedPayload() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
