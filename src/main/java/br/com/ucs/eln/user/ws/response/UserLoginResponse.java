package br.com.ucs.eln.user.ws.response;

import br.com.ucs.eln.ws.response.ApiResponse;

import java.util.ArrayList;
import java.util.List;

public class UserLoginResponse extends ApiResponse {
    private Long id;
    private String lock;
    private String email;
    private String username;
    private boolean fromAdminGroup;
    private List<String> allowedFunctions = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLock() {
        return lock;
    }

    public void setLock(String lock) {
        this.lock = lock;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isFromAdminGroup() {
        return fromAdminGroup;
    }

    public void setFromAdminGroup(boolean fromAdminGroup) {
        this.fromAdminGroup = fromAdminGroup;
    }

    public List<String> getAllowedFunctions() {
        return allowedFunctions;
    }

    public void setAllowedFunctions(List<String> allowedFunctions) {
        this.allowedFunctions = allowedFunctions;
    }
}
