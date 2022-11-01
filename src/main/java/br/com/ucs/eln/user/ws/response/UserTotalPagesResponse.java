package br.com.ucs.eln.user.ws.response;

import br.com.ucs.eln.ws.response.ApiResponse;

public class UserTotalPagesResponse extends ApiResponse {
    private int pages;

    public UserTotalPagesResponse(int pages) {
        this.pages = pages;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
