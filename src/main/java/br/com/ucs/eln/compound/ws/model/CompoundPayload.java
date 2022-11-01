package br.com.ucs.eln.compound.ws.model;

import java.io.Serializable;

public class CompoundPayload implements Serializable {
    private long id;
    private String created;
    private String name;
    private String description;
    private double molarMass;
    private String unitMeasure;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMolarMass() {
        return molarMass;
    }

    public void setMolarMass(double molarMass) {
        this.molarMass = molarMass;
    }

    public String getUnitMeasure() {
        return unitMeasure;
    }

    public void setUnitMeasure(String unitMeasure) {
        this.unitMeasure = unitMeasure;
    }
}
