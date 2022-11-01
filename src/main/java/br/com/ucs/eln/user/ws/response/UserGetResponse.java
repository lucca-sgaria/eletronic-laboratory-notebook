package br.com.ucs.eln.user.ws.response;

import br.com.ucs.eln.user.ws.model.UserPayload;
import br.com.ucs.eln.ws.response.ApiResponse;

public class UserGetResponse extends ApiResponse {
    private UserPayload user;

    public UserGetResponse(UserPayload user) {
        this.user = user;
    }

    public UserPayload getUser() {
        return user;
    }

    public void setUser(UserPayload user) {
        this.user = user;
    }
}
