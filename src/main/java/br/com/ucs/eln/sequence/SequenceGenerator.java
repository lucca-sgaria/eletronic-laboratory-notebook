package br.com.ucs.eln.sequence;

import br.com.ucs.eln.experiment.repository.ExperimentRepository;
import br.com.ucs.eln.project.repository.ProjectRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class SequenceGenerator {

    @Inject
    ProjectRepository projectRepository;
    @Inject
    ExperimentRepository experimentRepository;
    @Inject
    SequenceRepository sequenceRepository;

    public String generateProjectNumber() {
        while (true) {
            var sequence = sequenceRepository.getByName("Project Number");
            var number = String.format("P%09d", sequence.getCurrentValue());
            sequence.addCurrentValue();

            if (!projectRepository.existsByNumber(number)) return number;
        }
    }

    public String generateExperimentNumber() {
        while (true) {
            var sequence = sequenceRepository.getByName("Experiment Number");
            var number = String.format("E%09d", sequence.getCurrentValue());
            sequence.addCurrentValue();

            if (!experimentRepository.existsByNumber(number)) return number;
        }
    }
}
