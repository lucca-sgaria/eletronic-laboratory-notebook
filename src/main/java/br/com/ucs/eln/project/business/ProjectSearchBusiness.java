package br.com.ucs.eln.project.business;

import br.com.ucs.eln.group.model.Group;
import br.com.ucs.eln.project.model.Project;
import br.com.ucs.eln.project.repository.ProjectRepository;
import br.com.ucs.eln.user.model.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class ProjectSearchBusiness {

    @Inject
    ProjectRepository repository;

    public long searchCount(String searchKey, User user) {
        return repository.searchCount(searchKey, user);
    }

    public List<Project> searchProjects(int page, int pageSize, String searchKey, User user) {
        if (groupCanListAllProjects(user.getGroup())) {
            return repository.searchProjects(searchKey, page, pageSize, user);
        }
        return repository.searchUserProjects(searchKey, page, pageSize, user);
    }

    private boolean groupCanListAllProjects(Group group) {
        if (group.isAdmin()) return true;

        return group
                .getFunctions()
                .stream()
                .anyMatch(function -> function.getName().contains("listAllProjects"));
    }

}
