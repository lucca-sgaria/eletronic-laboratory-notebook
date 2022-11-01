package br.com.ucs.eln.compound.ws.response;

import br.com.ucs.eln.compound.ws.model.CompoundPayload;
import br.com.ucs.eln.ws.response.ApiResponse;

public class CompoundGetResponse extends ApiResponse {
    private CompoundPayload compound;

    public CompoundGetResponse(CompoundPayload compound) {
        this.compound = compound;
    }

    public CompoundPayload getCompound() {
        return compound;
    }

    public void setCompound(CompoundPayload compound) {
        this.compound = compound;
    }
}
