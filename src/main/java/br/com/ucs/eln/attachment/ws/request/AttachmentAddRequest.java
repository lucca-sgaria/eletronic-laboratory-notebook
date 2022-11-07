package br.com.ucs.eln.attachment.ws.request;

import br.com.ucs.eln.ws.request.Request;

import java.util.Arrays;

public class AttachmentAddRequest extends Request {
    private long experimentId;
    private long userId;
    private String name;
    private String externalLink;
    private String fileName;
    private byte[] file;

    public long getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(long experimentId) {
        this.experimentId = experimentId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExternalLink() {
        return externalLink;
    }

    public void setExternalLink(String externalLink) {
        this.externalLink = externalLink;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "AttachmentAddRequest{" +
                "experimentId=" + experimentId +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", externalLink='" + externalLink + '\'' +
                ", fileName='" + fileName + '\'' +
                ", file=" + Arrays.toString(file) +
                '}';
    }
}
