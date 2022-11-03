package br.com.ucs.eln.experiment.business;

import br.com.ucs.eln.experiment.model.Experiment;
import br.com.ucs.eln.experiment.repository.ExperimentRepository;
import br.com.ucs.eln.group.model.Group;
import br.com.ucs.eln.user.model.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class ExperimentSearchBusiness {

    @Inject
    ExperimentRepository repository;

    public long searchCount(String searchKey, User user) {
        if (groupCanListAllExperiments(user.getGroup())) {
            return repository.searchCount(searchKey, user);
        }
        return repository.searchCountUser(searchKey, user);
    }

    public List<Experiment> searchExperiments(int page, int pageSize, String searchKey, User user) {
        if (groupCanListAllExperiments(user.getGroup())) {
            return repository.searchExperiments(searchKey, page, pageSize, user);
        }
        return repository.searchUserExperiments(searchKey, page, pageSize, user);
    }

    private boolean groupCanListAllExperiments(Group group) {
        if (group.isAdmin()) return true;

        return group
                .getFunctions()
                .stream()
                .anyMatch(function -> function.getName().contains("listAllExperiments"));
    }
}
