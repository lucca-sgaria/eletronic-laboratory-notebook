package br.com.ucs.eln.group.ws.response;

import br.com.ucs.eln.ws.response.ApiResponse;

public class GroupTotalCountResponse extends ApiResponse {
    private long count;

    public GroupTotalCountResponse(long count) {
        this.count = count;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
