package br.com.ucs.eln.group.ws.request;


import br.com.ucs.eln.ws.request.Request;

import java.util.List;

public class GroupAddRequest extends Request {
    private String name;
    private String description;
    private boolean admin;
    private List<String> allowedFunctions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public List<String> getAllowedFunctions() {
        return allowedFunctions;
    }

    public void setAllowedFunctions(List<String> allowedFunctions) {
        this.allowedFunctions = allowedFunctions;
    }

    @Override
    public String toString() {
        return "GroupAddRequest{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", admin=" + admin +
                ", allowedFunctions=" + allowedFunctions +
                '}';
    }
}
