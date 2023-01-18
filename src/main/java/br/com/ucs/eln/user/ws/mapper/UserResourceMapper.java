package br.com.ucs.eln.user.ws.mapper;

import br.com.ucs.eln.group.model.Function;
import br.com.ucs.eln.project.model.Project;
import br.com.ucs.eln.user.model.User;
import br.com.ucs.eln.user.repository.UserRepository;
import br.com.ucs.eln.user.ws.response.SearchProfileProjectResponse;
import br.com.ucs.eln.user.ws.response.UserFinishRegistrationResponse;
import br.com.ucs.eln.user.ws.response.UserGetResponse;
import br.com.ucs.eln.user.ws.response.UserListResponse;
import br.com.ucs.eln.user.ws.response.UserLoginResponse;
import br.com.ucs.eln.user.ws.response.UserSearchCountResponse;
import br.com.ucs.eln.user.ws.response.UserSearchProfileResponse;
import br.com.ucs.eln.user.ws.response.UserSearchResponse;
import br.com.ucs.eln.user.ws.response.UserTotalCountResponse;
import br.com.ucs.eln.user.ws.response.UserTotalPagesResponse;
import br.com.ucs.eln.user.ws.response.UserUpdateResponse;
import br.com.ucs.eln.ws.response.ApiResponse;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class UserResourceMapper {

    @Inject
    UserRepository userRepository;
    @Inject
    UserPayloadMapper userPayloadMapper;
    @Inject
    UserProfilePayloadMapper userProfilePayloadMapper;
    @Inject
    ProfileProjectPayloadMapper profileProjectPayloadMapper;

    public UserLoginResponse mapToUserLoginResponse(User user) {
        var response = new UserLoginResponse();
        response.setId(user.getId());
        response.setLock(user.getLock().name());
        response.setEmail(user.getEmail());
        response.setUsername(user.getUsername());
        response.setFromAdminGroup(user.getGroup().isAdmin());
        response.setAllowedFunctions(getAllowedFunctions(user));

        return response;
    }

    public UserFinishRegistrationResponse mapToUserFinishRegistrationResponse(User user) {
        user = userRepository.findById(user.getId());

        var response = new UserFinishRegistrationResponse();
        response.setId(user.getId());
        response.setLock(user.getLock().name());
        response.setEmail(user.getEmail());
        response.setUsername(user.getUsername());
        response.setFromAdminGroup(user.getGroup().isAdmin());
        response.setAllowedFunctions(getAllowedFunctions(user));

        return response;
    }

    private List<String> getAllowedFunctions(User user) {
        if (user.getGroup().isAdmin()) return null;

        return user.getGroup().getFunctions()
                .stream()
                .filter(Function::isAllowed)
                .map(Function::getName)
                .collect(Collectors.toList());
    }


    public UserTotalCountResponse mapToTotalUsersCountResponse(long totalCount) {
        return new UserTotalCountResponse(totalCount);
    }

    public UserTotalPagesResponse mapToTotalUsersPagesResponse(int totalPages) {
        return new UserTotalPagesResponse(totalPages);
    }

    public UserListResponse mapToListUsersResponse(List<User> userList) {
        return new UserListResponse(userPayloadMapper.map(userList));
    }

    public UserSearchResponse mapToSearchUsersResponse(List<User> userList) {
        return new UserSearchResponse(userPayloadMapper.map(userList));
    }

    public UserSearchCountResponse mapToSearchUsersCountResponse(long count) {
        return new UserSearchCountResponse(count);
    }

    public UserGetResponse mapToUserGetResponse(User user) {
        return new UserGetResponse(userPayloadMapper.map(user));
    }

    public UserUpdateResponse mapToUserUpdateResponse(User user) {
        return new UserUpdateResponse(userPayloadMapper.map(user));
    }

    public ApiResponse mapTosearchProfileResponse(User user) {
        return new UserSearchProfileResponse(userProfilePayloadMapper.map(user));
    }

    public ApiResponse mapToProfileProjectsResponse(List<Project> projectList) {
        return new SearchProfileProjectResponse(profileProjectPayloadMapper.map(projectList));
    }
}
