package br.com.ucs.eln.experiment_line.ws.mapper;

import br.com.ucs.eln.experiment_line.model.ExperimentLine;
import br.com.ucs.eln.experiment_line.ws.response.ExperimentLineListResponse;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class ExperimentLineResourceMapper {

    @Inject
    ExperimentLinePayloadMapper payloadMapper;

    public ExperimentLineListResponse mapToListExperimentLinesResponse(List<ExperimentLine> lineList) {
        return new ExperimentLineListResponse(payloadMapper.map(lineList));
    }

}
