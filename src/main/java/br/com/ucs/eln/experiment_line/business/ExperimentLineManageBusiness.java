package br.com.ucs.eln.experiment_line.business;

import br.com.ucs.eln.compound.model.Compound;
import br.com.ucs.eln.experiment.model.Experiment;
import br.com.ucs.eln.experiment_line.model.ExperimentLine;
import br.com.ucs.eln.experiment_line.model.ExperimentLineType;
import br.com.ucs.eln.experiment_line.repository.ExperimentLineRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.Date;

@RequestScoped
public class ExperimentLineManageBusiness {

    @Inject
    ExperimentLineRepository repository;

    public void addExperimentLine(Experiment experiment,
                                  Compound compound,
                                  double amount,
                                  double moles,
                                  String type) {
        var line = new ExperimentLine();
        line.setExperiment(experiment);
        line.setSubstance(compound);
        line.setAmount(amount);
        line.setMoles(moles);
        line.setType(ExperimentLineType.valueOf(type));

        if (experiment.getExecutionDate() == null) {
            experiment.setExecutionDate(LocalDateTime.now());
        }

        repository.persist(line);
    }

    public void delete(Long id) {
        repository.delete(repository.findById(id));
    }

    public void updateExperimentLine(Long id,
                                     Double amount,
                                     Double moles,
                                     String type) {
        System.out.println(amount);
        System.out.println(moles);
        System.out.println(type);
        var line = repository.findById(id);
        if (amount != null) line.setAmount(amount);
        if (moles != null) line.setMoles(moles);
        if (type != null) line.setType(ExperimentLineType.valueOf(type));

        System.out.println(line);
    }
}
