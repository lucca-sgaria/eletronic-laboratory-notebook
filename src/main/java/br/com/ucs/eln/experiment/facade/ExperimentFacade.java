package br.com.ucs.eln.experiment.facade;

import br.com.ucs.eln.experiment.business.ExperimentListingBusiness;
import br.com.ucs.eln.experiment.business.ExperimentManageBusiness;
import br.com.ucs.eln.experiment.business.ExperimentSearchBusiness;
import br.com.ucs.eln.experiment.exception.ExperimentException;
import br.com.ucs.eln.experiment.model.Experiment;
import br.com.ucs.eln.project.exception.ProjectException;
import br.com.ucs.eln.project.model.Project;
import br.com.ucs.eln.project.repository.ProjectRepository;
import br.com.ucs.eln.user.exception.UserException;
import br.com.ucs.eln.user.repository.UserRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class ExperimentFacade {

    @Inject
    UserRepository userRepository;
    @Inject
    ProjectRepository projectRepository;
    @Inject
    ExperimentListingBusiness listingBusiness;
    @Inject
    ExperimentSearchBusiness searchBusiness;
    @Inject
    ExperimentManageBusiness manageBusiness;

    public long totalExperimentsCount(long userId) {
        var user = userRepository.findById(userId);
        return listingBusiness.totalCount(user);
    }

    public List<Experiment> listExperiments(int page, int pageSize, long userId) {
        var user = userRepository.findById(userId);
        return listingBusiness.listExperiments(page, pageSize, user);
    }

    public List<Experiment> searchExperiments(int page, int pageSize, String searchKey, long userId) {
        var user = userRepository.findById(userId);
        return searchBusiness.searchExperiments(page, pageSize, searchKey, user);
    }

    public long searchExperimentsCount(String searchKey, long userId) {
        var user = userRepository.findById(userId);
        return searchBusiness.searchCount(searchKey, user);
    }

    @Transactional
    public void addExperiment(String name,
                              String description,
                              long creatorId,
                              byte[] mainImage,
                              long projectId) throws UserException, ProjectException {
        var creator = userRepository.findExistingById(creatorId);
        var project = projectRepository.findExistingById(projectId);

        manageBusiness.addExperiment(name, description, creator, project, mainImage);
    }

    public Experiment getExperiment(Long id) throws ExperimentException {
        return manageBusiness.getExperimentById(id);
    }

    @Transactional
    public void updateExperiment(Long id,
                                 String name,
                                 String description,
                                 byte[] mainImage) throws ExperimentException {
        manageBusiness.updateExperiment(id, name, description, mainImage);
    }

    public List<Experiment> listExperiments(long projectId) {
        try {
            var project = projectRepository.findExistingById(projectId);
            return project.getExperiments();
        } catch (ProjectException e) {
            return new ArrayList<>();
        }
    }
}
