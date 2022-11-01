package br.com.ucs.eln.sequence;

import br.com.ucs.eln.project.repository.ProjectRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class SequenceGenerator {

    @Inject
    ProjectRepository projectRepository;
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
}
