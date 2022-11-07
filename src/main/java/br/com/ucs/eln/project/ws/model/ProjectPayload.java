package br.com.ucs.eln.project.ws.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProjectPayload implements Serializable {
    private long id;
    private String number;
    private String title;
    private String created;
    private String description;
    private int experimentsNumber;
    private int usersNumber;
    private boolean participant;
    private int state;
    private boolean onlyProjectUsers;
    private List<Long> projectUsers = new ArrayList<>();

    public ProjectPayload() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getExperimentsNumber() {
        return experimentsNumber;
    }

    public void setExperimentsNumber(int experimentsNumber) {
        this.experimentsNumber = experimentsNumber;
    }

    public int getUsersNumber() {
        return usersNumber;
    }

    public void setUsersNumber(int usersNumber) {
        this.usersNumber = usersNumber;
    }

    public boolean isParticipant() {
        return participant;
    }

    public void setParticipant(boolean participant) {
        this.participant = participant;
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

    public List<Long> getProjectUsers() {
        return projectUsers;
    }

    public void setProjectUsers(List<Long> projectUsers) {
        this.projectUsers = projectUsers;
    }
}
