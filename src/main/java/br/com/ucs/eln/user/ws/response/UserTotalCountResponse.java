package br.com.ucs.eln.user.ws.response;

import br.com.ucs.eln.ws.response.ApiResponse;

public class UserTotalCountResponse extends ApiResponse {
    private long count;

    public UserTotalCountResponse(long count) {
        this.count = count;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
