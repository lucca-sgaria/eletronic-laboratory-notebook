package br.com.ucs.eln.user.facade;

import br.com.ucs.eln.group.exception.GroupException;
import br.com.ucs.eln.project.model.Project;
import br.com.ucs.eln.user.business.UserFinishRegistrationBusiness;
import br.com.ucs.eln.user.business.UserListingBusiness;
import br.com.ucs.eln.user.business.UserLoginBusiness;
import br.com.ucs.eln.user.business.UserManageBusiness;
import br.com.ucs.eln.user.business.UserProfileBusiness;
import br.com.ucs.eln.user.business.UserRegisterBusiness;
import br.com.ucs.eln.user.business.UserSearchBusiness;
import br.com.ucs.eln.user.dto.UserDtoMapper;
import br.com.ucs.eln.user.exception.UserException;
import br.com.ucs.eln.user.model.User;
import br.com.ucs.eln.user.repository.UserRepository;
import br.com.ucs.eln.user.ws.model.UserPayload;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class UserFacade {

    @Inject
    UserRepository userRepository;

    @Inject
    UserDtoMapper dtoMapper;
    @Inject
    UserLoginBusiness loginBusiness;
    @Inject
    UserFinishRegistrationBusiness finishRegistrationBusiness;
    @Inject
    UserListingBusiness listingBusiness;
    @Inject
    UserSearchBusiness searchBusiness;
    @Inject
    UserRegisterBusiness registerBusiness;
    @Inject
    UserManageBusiness manageBusiness;
    @Inject
    UserProfileBusiness profileBusiness;

    public User login(String email, String password) throws UserException {
        return loginBusiness.login(email, password);
    }

    @Transactional
    public User finishRegistration(Long id,
                                   String fullName,
                                   String username,
                                   String password,
                                   String description) throws UserException {
        return finishRegistrationBusiness.finishRegistration(id, fullName, username, password, description);
    }

    public long totalUsersCount() {
        return listingBusiness.totalCount();
    }

    public int totalUsersPages(int pageSize) {
        return listingBusiness.totalPages(pageSize);
    }

    public List<User> listUsers(int page, int pageSize) {
        return listingBusiness.listUsers(page, pageSize);
    }

    public List<User> searchUsers(int page, int pageSize, String searchKey) {
        return searchBusiness.searchUsers(page, pageSize, searchKey);
    }

    public long searchUsersCount(String searchKey) {
        return searchBusiness.searchCount(searchKey);
    }

    @Transactional
    public void registerUser(String email, Long groupId) throws UserException, GroupException {
        registerBusiness.registerUser(email, groupId);
    }

    public User getUser(Long id) throws UserException {
        return manageBusiness.getUserById(id);
    }

    @Transactional
    public User updateUser(Long id, UserPayload userPayload) throws UserException, GroupException {
        return manageBusiness.updateUser(id, dtoMapper.map(userPayload));
    }

    @Transactional
    public void delete(Long id) throws UserException {
        User user = userRepository.findExistingById(id);
        userRepository.delete(user);
    }

    public User searchUserProfile(String searchKey, Long userId) throws UserException {
        return profileBusiness.searchUser(searchKey, userId);
    }

    public List<Project> searchUserProfileProjects(Long userId) throws UserException {
        User user = userRepository.findExistingById(userId);
        return user
                .getProjects()
                .stream()
                .sorted(Comparator.comparing(Project::getId).reversed())
                .collect(Collectors.toList());
    }
}
