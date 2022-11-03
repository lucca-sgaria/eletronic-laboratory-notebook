package br.com.ucs.eln.experiment.ws.response;

import br.com.ucs.eln.experiment.ws.model.ExperimentPayload;
import br.com.ucs.eln.ws.response.ApiResponse;

public class ExperimentGetResponse extends ApiResponse {
    private ExperimentPayload experiment;

    public ExperimentGetResponse(ExperimentPayload experiment) {
        this.experiment = experiment;
    }

    public ExperimentPayload getExperiment() {
        return experiment;
    }

    public void setExperiment(ExperimentPayload experiment) {
        this.experiment = experiment;
    }
}
