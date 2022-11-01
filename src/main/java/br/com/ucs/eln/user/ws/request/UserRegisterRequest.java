package br.com.ucs.eln.user.ws.request;

import br.com.ucs.eln.ws.request.Request;

public class UserRegisterRequest extends Request {
    private String email;
    private Long groupId;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
}
