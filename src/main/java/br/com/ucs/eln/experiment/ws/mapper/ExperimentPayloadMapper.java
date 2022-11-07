package br.com.ucs.eln.experiment.ws.mapper;

import br.com.ucs.eln.experiment.model.Experiment;
import br.com.ucs.eln.experiment.ws.model.ExperimentPayload;
import br.com.ucs.eln.globals.DateUtil;
import br.com.ucs.eln.user.model.User;

import javax.enterprise.context.RequestScoped;
import java.time.LocalDateTime;
import java.util.List;

@RequestScoped
public class ExperimentPayloadMapper {

    public List<ExperimentPayload> map(List<Experiment> experimentList, User user) {
        return experimentList
                .stream()
                .map(experiment -> map(experiment, user))
                .toList();
    }

    public ExperimentPayload map(Experiment experiment, User user) {
        var payload = new ExperimentPayload();
        payload.setId(experiment.getId());
        payload.setNumber(experiment.getNumber());
        payload.setName(experiment.getName());
        payload.setCreated(formatDate(experiment.getCreated()));
        payload.setDescription(experiment.getDescription());
        payload.setCreatorName(experiment.getCreator().getFullName());
        payload.setCreatorId(experiment.getCreator().getId());
        payload.setExecutionDate(formatDate(experiment.getExecutionDate()));
        payload.setMainImage(experiment.getMainImage());
        payload.setProjectNumber(experiment.getProject().getNumber());
        payload.setProjectId(experiment.getProject().getId());
        if (user != null) {
            payload.setProjectParticipant(experiment.getProject().getUsers().contains(user));
        }
        return payload;
    }

    private static String formatDate(LocalDateTime date) {
        if (date == null) return null;

        return DateUtil.formatDate(date);
    }

}
