package br.com.ucs.eln.project.business;

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
        return repository.searchProjects(searchKey, page, pageSize, user);
    }
}
