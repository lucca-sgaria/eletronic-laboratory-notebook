package br.com.ucs.eln.user.ws.response;

import br.com.ucs.eln.user.ws.model.UserPayload;
import br.com.ucs.eln.ws.response.ApiResponse;

import java.util.List;

public class UserSearchResponse extends ApiResponse {
    private List<UserPayload> userList;

    public UserSearchResponse(List<UserPayload> userList) {
        this.userList = userList;
    }

    public List<UserPayload> getUserList() {
        return userList;
    }

    public void setUserList(List<UserPayload> userList) {
        this.userList = userList;
    }
}
