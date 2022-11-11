package br.com.ucs.eln.experiment.ws.response;

import br.com.ucs.eln.experiment.ws.model.ExperimentResumedPayload;
import br.com.ucs.eln.ws.response.ApiResponse;

import java.util.List;

public class ExperimentResumedListResponse extends ApiResponse {
    private List<ExperimentResumedPayload> experimentList;

    public ExperimentResumedListResponse(List<ExperimentResumedPayload> experimentList) {
        this.experimentList = experimentList;
    }

    public List<ExperimentResumedPayload> getExperimentList() {
        return experimentList;
    }

    public void setExperimentList(List<ExperimentResumedPayload> experimentList) {
        this.experimentList = experimentList;
    }
}
