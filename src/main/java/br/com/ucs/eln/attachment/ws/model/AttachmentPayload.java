package br.com.ucs.eln.attachment.ws.model;

import java.io.Serializable;
import java.util.Arrays;

public class AttachmentPayload implements Serializable {
    private long id;
    private String creatorName;
    private String creationDate;
    private String name;
    private byte[] file;
    private String fileName;
    private String externalLink;

    public AttachmentPayload() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getExternalLink() {
        return externalLink;
    }

    public void setExternalLink(String externalLink) {
        this.externalLink = externalLink;
    }

    @Override
    public String toString() {
        return "AttachmentPayload{" +
                "id=" + id +
                ", creatorName='" + creatorName + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", name='" + name + '\'' +
                ", file=" + Arrays.toString(file) +
                ", fileName='" + fileName + '\'' +
                ", externalLink='" + externalLink + '\'' +
                '}';
    }
}
