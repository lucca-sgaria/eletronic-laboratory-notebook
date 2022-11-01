package br.com.ucs.eln.project.ws.response;

import br.com.ucs.eln.ws.response.ApiResponse;

public class ProjectSearchCountResponse extends ApiResponse {
    private long count;

    public ProjectSearchCountResponse(long count) {
        this.count = count;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
