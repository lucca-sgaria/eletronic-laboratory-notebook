package br.com.ucs.eln.user.ws.response;

import br.com.ucs.eln.user.ws.model.UserProfilePayload;
import br.com.ucs.eln.ws.response.ApiResponse;

public class UserSearchProfileResponse extends ApiResponse {
    private UserProfilePayload user;

    public UserSearchProfileResponse(UserProfilePayload user) {
        this.user = user;
    }

    public UserProfilePayload getUser() {
        return user;
    }

    public void setUser(UserProfilePayload user) {
        this.user = user;
    }
}
