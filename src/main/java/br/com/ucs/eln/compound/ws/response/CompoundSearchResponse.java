package br.com.ucs.eln.compound.ws.response;

import br.com.ucs.eln.compound.ws.model.CompoundPayload;
import br.com.ucs.eln.ws.response.ApiResponse;

import java.util.List;

public class CompoundSearchResponse extends ApiResponse {
    private List<CompoundPayload> compoundList;


    public CompoundSearchResponse(List<CompoundPayload> compoundList) {
        this.compoundList = compoundList;
    }

    public List<CompoundPayload> getCompoundList() {
        return compoundList;
    }

    public void setCompoundList(List<CompoundPayload> compoundList) {
        this.compoundList = compoundList;
    }
}
