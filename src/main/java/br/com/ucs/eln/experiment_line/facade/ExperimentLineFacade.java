package br.com.ucs.eln.experiment_line.facade;

import br.com.ucs.eln.compound.exception.CompoundException;
import br.com.ucs.eln.compound.repository.CompoundRepository;
import br.com.ucs.eln.experiment.exception.ExperimentException;
import br.com.ucs.eln.experiment.repository.ExperimentRepository;
import br.com.ucs.eln.experiment_line.business.ExperimentLineManageBusiness;
import br.com.ucs.eln.experiment_line.model.ExperimentLine;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
public class ExperimentLineFacade {

    @Inject
    ExperimentRepository experimentRepository;
    @Inject
    CompoundRepository compoundRepository;
    @Inject
    ExperimentLineManageBusiness manageBusiness;

    public List<ExperimentLine> listExperimentLines(long experimentId) throws ExperimentException {
        var experiment = experimentRepository.findExistingById(experimentId);
        return experiment.getLines();
    }

    @Transactional
    public void addExperimentLine(long experimentId,
                                  long compoundId,
                                  double amount,
                                  double moles,
                                  String type) throws ExperimentException, CompoundException {
        var experiment = experimentRepository.findExistingById(experimentId);
        var compound = compoundRepository.findExistingById(compoundId);

        manageBusiness.addExperimentLine(experiment, compound, amount, moles, type);
    }

    @Transactional
    public void deleteExperimentLine(Long id) {
        manageBusiness.delete(id);
    }


    @Transactional
    public void updateExperimentLine(Long id,
                                     Double amount,
                                     Double moles,
                                     String type) {
        manageBusiness.updateExperimentLine(id, amount, moles, type);
    }
}
