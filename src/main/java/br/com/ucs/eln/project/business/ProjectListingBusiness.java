package br.com.ucs.eln.project.business;

import br.com.ucs.eln.group.model.Group;
import br.com.ucs.eln.project.model.Project;
import br.com.ucs.eln.project.repository.ProjectRepository;
import br.com.ucs.eln.user.model.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class ProjectListingBusiness {

    @Inject
    ProjectRepository repository;

    public long totalCount(User user) {
        if (groupCanListAllProjects(user.getGroup())) {
            return repository.countProjects(user);
        }
        return repository.countUserProjects(user);
    }

    public List<Project> listProjects(int page, int pageSize, User user) {
        if (groupCanListAllProjects(user.getGroup())) {
            return repository.list(page, pageSize, user);
        }
        return repository.listUserProjects(page, pageSize, user);
    }

    private boolean groupCanListAllProjects(Group group) {
        if (group.isAdmin()) return true;

        return group
                .getFunctions()
                .stream()
                .anyMatch(function -> function.getName().contains("listAllProjects"));
    }

    public List<Project> listOpenedUserProjects(User user) {
        return repository.listOpenedUserProjects(user);
    }
}
