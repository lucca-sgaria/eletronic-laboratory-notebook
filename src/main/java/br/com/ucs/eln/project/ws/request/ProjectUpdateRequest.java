package br.com.ucs.eln.project.ws.request;

import br.com.ucs.eln.ws.request.Request;

public class ProjectUpdateRequest extends Request {
    private String number;
    private String title;
    private String description;
    private int state;
    private boolean onlyProjectUsers;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public boolean isOnlyProjectUsers() {
        return onlyProjectUsers;
    }

    public void setOnlyProjectUsers(boolean onlyProjectUsers) {
        this.onlyProjectUsers = onlyProjectUsers;
    }
}
