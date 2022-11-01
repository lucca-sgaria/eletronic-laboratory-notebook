package br.com.ucs.eln.project.ws.response;

import br.com.ucs.eln.ws.response.ApiResponse;

public class ProjectTotalCountResponse extends ApiResponse {
    private long count;

    public ProjectTotalCountResponse(long count) {
        this.count = count;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
