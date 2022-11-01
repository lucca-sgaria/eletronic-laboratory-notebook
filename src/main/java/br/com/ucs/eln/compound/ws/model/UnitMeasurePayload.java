package br.com.ucs.eln.compound.ws.model;

import br.com.ucs.eln.compound.model.UnitMeasure;

import java.io.Serializable;

public class UnitMeasurePayload implements Serializable {
    private long id;
    private String name;

    public UnitMeasurePayload(UnitMeasure unitMeasure) {
        this.id = unitMeasure.getId();
        this.name = unitMeasure.getName();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
