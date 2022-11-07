package br.com.ucs.eln.experiment.ws.request;

import br.com.ucs.eln.ws.request.Request;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExperimentAddRequest extends Request {
    private String name;
    private String description;
    private long creatorId;
    private byte[] mainImage;
    private long projectId;

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

    public long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(long creatorId) {
        this.creatorId = creatorId;
    }

    public byte[] getMainImage() {
        return mainImage;
    }

    public void setMainImage(byte[] mainImage) {
        this.mainImage = mainImage;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "ExperimentAddRequest{" +
                "name='" + name + '\'' +
                ", descriptaion='" + description + '\'' +
                ", creatorId=" + creatorId +
                ", mainImage=" + Arrays.toString(mainImage) +
                ", projectId=" + projectId +
                '}';
    }
}
