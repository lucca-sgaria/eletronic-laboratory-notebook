package br.com.ucs.eln.group.ws.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GroupPayload implements Serializable {
    private long id;
    private String created;
    private String name;
    private String description;
    private boolean admin;
    private List<String> allowedFunctions = new ArrayList<>();
    private int userNumber;

    public GroupPayload() {
    }

    public GroupPayload(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

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

    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }
}
