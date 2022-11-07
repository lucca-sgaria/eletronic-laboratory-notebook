package br.com.ucs.eln.comment.ws.response;

import br.com.ucs.eln.ws.response.ApiResponse;

public class CommentCountResponse extends ApiResponse {
    private long count;

    public CommentCountResponse(long count) {
        this.count = count;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
