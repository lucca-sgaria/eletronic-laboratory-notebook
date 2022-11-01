package br.com.ucs.eln.project.facade;

import br.com.ucs.eln.project.business.ProjectListingBusiness;
import br.com.ucs.eln.project.business.ProjectManageBusiness;
import br.com.ucs.eln.project.business.ProjectSearchBusiness;
import br.com.ucs.eln.project.exception.ProjectException;
import br.com.ucs.eln.project.model.Project;
import br.com.ucs.eln.user.exception.UserException;
import br.com.ucs.eln.user.repository.UserRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
public class ProjectFacade {

    @Inject
    UserRepository userRepository;
    @Inject
    ProjectListingBusiness listingBusiness;
    @Inject
    ProjectSearchBusiness searchBusiness;
    @Inject
    ProjectManageBusiness manageBusiness;

    public long totalProjectsCount(long userId) {
        var user = userRepository.findById(userId);
        return listingBusiness.totalCount(user);
    }

    public List<Project> listProjects(int page, int pageSize, long userId) {
        var user = userRepository.findById(userId);
        return listingBusiness.listProjects(page, pageSize, user);
    }

    public List<Project> searchProjects(int page, int pageSize, String searchKey, long userId) {
        var user = userRepository.findById(userId);
        return searchBusiness.searchProjects(page, pageSize, searchKey, user);
    }

    public long searchProjectsCount(String searchKey, long userId) {
        var user = userRepository.findById(userId);
        return searchBusiness.searchCount(searchKey, user);
    }

    @Transactional
    public void addProject(long userId,
                           String title,
                           String description,
                           int state,
                           boolean onlyProjectUsers,
                           List<Long> userIds) throws ProjectException, UserException {
        var user = userRepository.findById(userId);
        var userList = userRepository.findExistingByIdList(userIds);
        manageBusiness.addProject(user, title, description, state, onlyProjectUsers, userList);
    }

    public Project getProject(Long id) throws ProjectException {
        return manageBusiness.getProjectById(id);
    }

    @Transactional
    public void updateProject(Long id,
                              String title,
                              String description,
                              int state,
                              boolean onlyProjectUsers) throws ProjectException {
        manageBusiness.updateProject(id, title, description, state, onlyProjectUsers);
    }
}
