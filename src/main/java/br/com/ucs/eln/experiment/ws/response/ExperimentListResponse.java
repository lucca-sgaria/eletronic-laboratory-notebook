package br.com.ucs.eln.experiment.ws.response;

import br.com.ucs.eln.experiment.ws.model.ExperimentPayload;
import br.com.ucs.eln.ws.response.ApiResponse;

import java.util.List;

public class ExperimentListResponse extends ApiResponse {
    private List<ExperimentPayload> experimentList;

    public ExperimentListResponse(List<ExperimentPayload> experimentList) {
        this.experimentList = experimentList;
    }

    public List<ExperimentPayload> getExperimentList() {
        return experimentList;
    }

    public void setExperimentList(List<ExperimentPayload> experimentList) {
        this.experimentList = experimentList;
    }
}
