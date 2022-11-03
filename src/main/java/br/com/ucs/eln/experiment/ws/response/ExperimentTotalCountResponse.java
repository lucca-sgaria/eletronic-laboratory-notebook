package br.com.ucs.eln.experiment.ws.response;

import br.com.ucs.eln.ws.response.ApiResponse;

public class ExperimentTotalCountResponse extends ApiResponse {
    private long count;

    public ExperimentTotalCountResponse(long count) {
        this.count = count;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
