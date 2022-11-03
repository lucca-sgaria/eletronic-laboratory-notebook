package br.com.ucs.eln.experiment.business;

import br.com.ucs.eln.experiment.model.Experiment;
import br.com.ucs.eln.experiment.repository.ExperimentRepository;
import br.com.ucs.eln.group.model.Group;
import br.com.ucs.eln.user.model.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class ExperimentListingBusiness {

    @Inject
    ExperimentRepository repository;

    public long totalCount(User user) {
        if (groupCanListAllExperiments(user.getGroup())) {
            return repository.countExperiments(user);
        }
        return repository.countUserExperiments(user);
    }

    public List<Experiment> listExperiments(int page, int pageSize, User user) {
        if (groupCanListAllExperiments(user.getGroup())) {
            return repository.list(page, pageSize, user);
        }
        return repository.listUserExperiments(page, pageSize, user);
    }

    private boolean groupCanListAllExperiments(Group group) {
        if (group.isAdmin()) return true;

        return group
                .getFunctions()
                .stream()
                .anyMatch(function -> function.getName().contains("listAllExperiments"));
    }

}
