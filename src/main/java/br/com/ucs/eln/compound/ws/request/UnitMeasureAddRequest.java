package br.com.ucs.eln.compound.ws.request;

import br.com.ucs.eln.ws.request.Request;

public class UnitMeasureAddRequest extends Request {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
