package br.com.ucs.eln.project.ws.request;

import br.com.ucs.eln.ws.request.Request;

import java.util.ArrayList;
import java.util.List;

public class ProjectAddRequest extends Request {
    private String number;
    private String title;
    private String description;
    private int state;
    private boolean onlyProjectUsers;
    private List<Long> userIds = new ArrayList<>();

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

    public List<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }
}
