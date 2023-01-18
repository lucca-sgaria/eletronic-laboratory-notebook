package br.com.ucs.eln.experiment.ws.mapper;

import br.com.ucs.eln.experiment.model.Experiment;
import br.com.ucs.eln.experiment.ws.response.ExperimentGetResponse;
import br.com.ucs.eln.experiment.ws.response.ExperimentListResponse;
import br.com.ucs.eln.experiment.ws.response.ExperimentResumedListResponse;
import br.com.ucs.eln.experiment.ws.response.ExperimentSearchCountResponse;
import br.com.ucs.eln.experiment.ws.response.ExperimentSearchResponse;
import br.com.ucs.eln.experiment.ws.response.ExperimentTotalCountResponse;
import br.com.ucs.eln.user.repository.UserRepository;
import br.com.ucs.eln.ws.response.ApiResponse;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class ExperimentResourceMapper {

    @Inject
    ExperimentPayloadMapper payloadMapper;
    @Inject
    ExperimentResumedPayloadMapper resumedPayloadMapper;
    @Inject
    UserRepository userRepository;

    public ExperimentTotalCountResponse mapToTotalExperimentsCountResponse(long totalCount) {
        return new ExperimentTotalCountResponse(totalCount);
    }

    public ExperimentListResponse mapToListExperimentsResponse(List<Experiment> experimentList, long userId) {
        var user = userRepository.findById(userId);
        return new ExperimentListResponse(payloadMapper.map(experimentList, user));
    }

    public ExperimentSearchResponse mapToSearchExperimentsResponse(List<Experiment> experimentList, long userId) {
        var user = userRepository.findById(userId);
        return new ExperimentSearchResponse(payloadMapper.map(experimentList, user));
    }

    public ExperimentSearchCountResponse mapToSearchExperimentsCountResponse(long count) {
        return new ExperimentSearchCountResponse(count);
    }

    public ExperimentGetResponse mapToExperimentGetResponse(Experiment experiment) {
        return new ExperimentGetResponse(payloadMapper.map(experiment, null));
    }

    public ExperimentResumedListResponse mapToListExperimentsResumedResponse(List<Experiment> experimentList) {
        return new ExperimentResumedListResponse(resumedPayloadMapper.map(experimentList));
    }
}
