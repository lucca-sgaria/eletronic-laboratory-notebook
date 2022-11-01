package br.com.ucs.eln.group.ws.response;

import br.com.ucs.eln.ws.response.ApiResponse;

public class GroupSearchCountResponse extends ApiResponse {
    private long count;

    public GroupSearchCountResponse(long count) {
        this.count = count;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
