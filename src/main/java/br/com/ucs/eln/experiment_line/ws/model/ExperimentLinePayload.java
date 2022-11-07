package br.com.ucs.eln.experiment_line.ws.model;

import java.io.Serializable;

public class ExperimentLinePayload implements Serializable {
    private long id;
    private String creationDate;
    private String compoundName;
    private double compoundMolarMass;
    private double amount;
    private double moles;
    private String type;

    public ExperimentLinePayload() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getCompoundName() {
        return compoundName;
    }

    public void setCompoundName(String compoundName) {
        this.compoundName = compoundName;
    }

    public double getCompoundMolarMass() {
        return compoundMolarMass;
    }

    public void setCompoundMolarMass(double compoundMolarMass) {
        this.compoundMolarMass = compoundMolarMass;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getMoles() {
        return moles;
    }

    public void setMoles(double moles) {
        this.moles = moles;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
