package br.com.ucs.eln.compound.ws.response;

import br.com.ucs.eln.ws.response.ApiResponse;

public class CompoundSearchCountResponse extends ApiResponse {
    private long count;

    public CompoundSearchCountResponse(long count) {
        this.count = count;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
