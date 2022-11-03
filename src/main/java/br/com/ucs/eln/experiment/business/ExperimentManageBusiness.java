package br.com.ucs.eln.experiment.business;

import br.com.ucs.eln.experiment.exception.ExperimentException;
import br.com.ucs.eln.experiment.model.Experiment;
import br.com.ucs.eln.experiment.repository.ExperimentRepository;
import br.com.ucs.eln.project.exception.ProjectException;
import br.com.ucs.eln.project.model.Project;
import br.com.ucs.eln.sequence.SequenceGenerator;
import br.com.ucs.eln.user.model.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class ExperimentManageBusiness {

    @Inject
    ExperimentRepository repository;
    @Inject
    SequenceGenerator sequenceGenerator;


    public void addExperiment(String name,
                              String description,
                              User creator,
                              Project project,
                              byte[] mainImage)  {

        var experiment = new Experiment();
        experiment.setNumber(sequenceGenerator.generateExperimentNumber());
        experiment.setName(name);
        experiment.setDescription(description);
        experiment.setCreator(creator);
        experiment.setProject(project);
        experiment.setMainImage(mainImage);

        repository.persist(experiment);
    }

    public void updateExperiment(Long id,
                                 String name,
                                 String description,
                                 byte[] mainImage) throws ExperimentException {
        var experiment = getExperimentById(id);
        experiment.setName(name);
        experiment.setDescription(description);
        experiment.setMainImage(mainImage);
    }

    public Experiment getExperimentById(Long id) throws ExperimentException {
        return repository.findExistingById(id);
    }


}
