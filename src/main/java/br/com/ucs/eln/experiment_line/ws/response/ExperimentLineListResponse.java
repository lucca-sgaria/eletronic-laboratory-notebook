package br.com.ucs.eln.experiment_line.ws.response;

import br.com.ucs.eln.experiment_line.ws.model.ExperimentLinePayload;
import br.com.ucs.eln.ws.response.ApiResponse;

import java.util.List;

public class ExperimentLineListResponse extends ApiResponse {
    private List<ExperimentLinePayload> lineList;

    public ExperimentLineListResponse(List<ExperimentLinePayload> lineList) {
        this.lineList = lineList;
    }

    public List<ExperimentLinePayload> getLineList() {
        return lineList;
    }

    public void setLineList(List<ExperimentLinePayload> lineList) {
        this.lineList = lineList;
    }
}
