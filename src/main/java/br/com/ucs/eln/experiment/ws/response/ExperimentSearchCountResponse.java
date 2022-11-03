package br.com.ucs.eln.experiment.ws.response;

import br.com.ucs.eln.ws.response.ApiResponse;

public class ExperimentSearchCountResponse extends ApiResponse {
    private long count;

    public ExperimentSearchCountResponse(long count) {
        this.count = count;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
