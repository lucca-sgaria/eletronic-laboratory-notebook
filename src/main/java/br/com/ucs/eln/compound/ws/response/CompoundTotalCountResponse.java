package br.com.ucs.eln.compound.ws.response;

import br.com.ucs.eln.ws.response.ApiResponse;

public class CompoundTotalCountResponse extends ApiResponse {
    private long count;

    public CompoundTotalCountResponse(long count) {
        this.count = count;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
