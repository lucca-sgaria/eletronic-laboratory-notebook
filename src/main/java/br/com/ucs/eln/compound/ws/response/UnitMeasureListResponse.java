package br.com.ucs.eln.compound.ws.response;

import br.com.ucs.eln.compound.ws.model.UnitMeasurePayload;
import br.com.ucs.eln.ws.response.ApiResponse;

import java.util.List;

public class UnitMeasureListResponse extends ApiResponse {
    private List<UnitMeasurePayload> unitMeasureList;

    public UnitMeasureListResponse(List<UnitMeasurePayload> unitMeasureList) {
        this.unitMeasureList = unitMeasureList;
    }

    public List<UnitMeasurePayload> getUnitMeasureList() {
        return unitMeasureList;
    }

    public void setUnitMeasureList(List<UnitMeasurePayload> unitMeasureList) {
        this.unitMeasureList = unitMeasureList;
    }
}
