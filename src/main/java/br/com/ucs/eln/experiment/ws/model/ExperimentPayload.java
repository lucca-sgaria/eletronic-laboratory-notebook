package br.com.ucs.eln.experiment.ws.model;

import java.io.Serializable;
import java.util.Arrays;

public class ExperimentPayload implements Serializable {
    private long id;
    private String number;
    private String name;
    private String created;
    private String description;
    private String creatorName;
    private long creatorId;
    private String executionDate;
    private byte[] mainImage;
    private String projectNumber;
    private long projectId;
    private boolean projectParticipant;

    public ExperimentPayload() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(long creatorId) {
        this.creatorId = creatorId;
    }

    public String getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(String executionDate) {
        this.executionDate = executionDate;
    }

    public byte[] getMainImage() {
        return mainImage;
    }

    public void setMainImage(byte[] mainImage) {
        this.mainImage = mainImage;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public boolean isProjectParticipant() {
        return projectParticipant;
    }

    public void setProjectParticipant(boolean projectParticipant) {
        this.projectParticipant = projectParticipant;
    }

    @Override
    public String toString() {
        return "ExperimentPayload{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", created='" + created + '\'' +
                ", description='" + description + '\'' +
                ", creatorName='" + creatorName + '\'' +
                ", creatorId=" + creatorId +
                ", executionDate='" + executionDate + '\'' +
                ", mainImage=" + Arrays.toString(mainImage) +
                ", projectNumber='" + projectNumber + '\'' +
                ", projectId=" + projectId +
                ", projectParticipant=" + projectParticipant +
                '}';
    }
}
