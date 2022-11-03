package br.com.ucs.eln.project.business;

import br.com.ucs.eln.project.exception.ProjectException;
import br.com.ucs.eln.project.model.Project;
import br.com.ucs.eln.project.repository.ProjectRepository;
import br.com.ucs.eln.sequence.SequenceGenerator;
import br.com.ucs.eln.user.model.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class ProjectManageBusiness {

    @Inject
    ProjectRepository repository;
    @Inject
    SequenceGenerator sequenceGenerator;


    public void addProject(String title,
                           String description,
                           int state,
                           boolean onlyProjectUsers,
                           List<User> userList) throws ProjectException {
        var project = new Project();
        project.setNumber(sequenceGenerator.generateProjectNumber());
        project.setTitle(title);
        project.setDescription(description);
        project.setState(state);
        project.setOnlyProjectUsers(onlyProjectUsers);

        repository.persist(project);
        project.setUsers(userList);
    }

    public Project getProjectById(Long id) throws ProjectException {
        return repository.findExistingById(id);
    }

    public void updateProject(Long id,
                              String title,
                              String description,
                              int state,
                              boolean onlyProjectUsers,
                              List<User> userList) throws ProjectException {
        var project = getProjectById(id);
        project.setTitle(title);
        project.setDescription(description);
        project.setState(state);
        project.setOnlyProjectUsers(onlyProjectUsers);
        project.setUsers(userList);
    }

}
