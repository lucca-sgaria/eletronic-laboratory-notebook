package br.com.ucs.eln.experiment.ws.mapper;

import br.com.ucs.eln.experiment.model.Experiment;
import br.com.ucs.eln.experiment.ws.model.ExperimentPayload;
import br.com.ucs.eln.experiment.ws.model.ExperimentResumedPayload;
import br.com.ucs.eln.globals.DateUtil;
import br.com.ucs.eln.user.model.User;

import javax.enterprise.context.RequestScoped;
import java.time.LocalDateTime;
import java.util.List;

@RequestScoped
public class ExperimentResumedPayloadMapper {

    public List<ExperimentResumedPayload> map(List<Experiment> experimentList) {
        return experimentList
                .stream()
                .map(this::map)
                .toList();
    }

    public ExperimentResumedPayload map(Experiment experiment) {
        var payload = new ExperimentResumedPayload();
        payload.setId(experiment.getId());
        payload.setNumber(experiment.getNumber());
        payload.setName(experiment.getName());

        return payload;
    }
}
