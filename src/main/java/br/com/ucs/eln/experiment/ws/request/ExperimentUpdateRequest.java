package br.com.ucs.eln.experiment.ws.request;

import br.com.ucs.eln.ws.request.Request;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExperimentUpdateRequest extends Request {
    private String name;
    private String description;
    private byte[] mainImage;

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

    public byte[] getMainImage() {
        return mainImage;
    }

    public void setMainImage(byte[] mainImage) {
        this.mainImage = mainImage;
    }

    @Override
    public String toString() {
        return "ExperimentUpdateRequest{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", mainImage=" + Arrays.toString(mainImage) +
                '}';
    }
}
