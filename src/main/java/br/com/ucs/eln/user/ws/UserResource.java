package br.com.ucs.eln.user.ws;

import br.com.ucs.eln.user.dto.UserDtoMapper;
import br.com.ucs.eln.user.exception.UserException;
import br.com.ucs.eln.user.facade.UserFacade;
import br.com.ucs.eln.user.ws.flag.UserFinishRegistrationError;
import br.com.ucs.eln.user.ws.flag.UserGetError;
import br.com.ucs.eln.user.ws.flag.UserLoginError;
import br.com.ucs.eln.user.ws.flag.UserRegisterError;
import br.com.ucs.eln.user.ws.flag.UserUpdateError;
import br.com.ucs.eln.user.ws.mapper.UserResourceMapper;
import br.com.ucs.eln.user.ws.model.UserPayload;
import br.com.ucs.eln.user.ws.request.UserFinishRegistrationRequest;
import br.com.ucs.eln.user.ws.request.UserLoginRequest;
import br.com.ucs.eln.user.ws.request.UserRegisterRequest;
import br.com.ucs.eln.ws.response.ApiResponseBuilder;
import org.jboss.resteasy.reactive.RestQuery;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserFacade facade;
    @Inject
    UserDtoMapper dtoMapper;
    @Inject
    UserResourceMapper resourceMapper;

    @POST
    @Path("/login")
    public Response login(UserLoginRequest request) {
        try {
            var user = facade.login(request.getEmail(), request.getPassword());
            return ApiResponseBuilder.ok(resourceMapper.mapToUserLoginResponse(user));
        } catch (Exception e) {
            return ApiResponseBuilder.error(UserLoginError.resolve(e));
        }
    }

    @POST
    @Path("/finish-registration")
    public Response finishRegistration(UserFinishRegistrationRequest request) {
        try {
            var user = facade.finishRegistration(
                    request.getId(),
                    request.getFullName(),
                    request.getUsername(),
                    request.getPassword(),
                    request.getDescription()
            );
            return ApiResponseBuilder.ok(resourceMapper.mapToUserFinishRegistrationResponse(user));
        } catch (Exception e) {
            return ApiResponseBuilder.error(UserFinishRegistrationError.resolve(e));
        }
    }

    @GET
    @Path("/count")
    public Response totalUsersCount() {
        var totalCount = facade.totalUsersCount();
        return ApiResponseBuilder.ok(resourceMapper.mapToTotalUsersCountResponse(totalCount));
    }

    @GET
    @Path("/pages")
    public Response totalUsersPages(@RestQuery int pageSize) {
        var totalPages = facade.totalUsersPages(pageSize);
        return ApiResponseBuilder.ok(resourceMapper.mapToTotalUsersPagesResponse(totalPages));
    }

    @GET
    public Response listUsers(@RestQuery int page,
                              @RestQuery int pageSize) {
        var userList = facade.listUsers(page, pageSize);
        return ApiResponseBuilder.ok(resourceMapper.mapToListUsersResponse(userList));
    }

    @GET
    @Path("/search")
    public Response searchUsers(@RestQuery String searchKey,
                                @RestQuery int page,
                                @RestQuery int pageSize) {
        var userList = facade.searchUsers(page, pageSize, searchKey);
        return ApiResponseBuilder.ok(resourceMapper.mapToSearchUsersResponse(userList));
    }

    @GET
    @Path("/search-count")
    public Response searchUsersCount(@RestQuery String searchKey) {
        var totalCount = facade.searchUsersCount(searchKey);
        return ApiResponseBuilder.ok(resourceMapper.mapToSearchUsersCountResponse(totalCount));
    }

    @POST
    @Path("/register")
    public Response registerUser(UserRegisterRequest request) {
        try {
            facade.registerUser(request.getEmail(), request.getGroupId());
            return ApiResponseBuilder.ok();
        } catch (Exception e) {
            return ApiResponseBuilder.error(UserRegisterError.resolve(e));
        }
    }

    @GET
    @Path("/{id}")
    public Response getUser(Long id) {
        try {
            var user = facade.getUser(id);
            return ApiResponseBuilder.ok(resourceMapper.mapToUserGetResponse(user));
        } catch (Exception e) {
            return ApiResponseBuilder.error(UserGetError.resolve(e));
        }
    }

    @PATCH
    @Path("/{id}")
    public Response updateUser(Long id, UserPayload userPayload) {
        try {
            var user = facade.updateUser(id, userPayload);
            return ApiResponseBuilder.ok(resourceMapper.mapToUserUpdateResponse(user));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ApiResponseBuilder.error(UserUpdateError.resolve(e));
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(Long id) throws UserException {
        facade.delete(id);
        return Response.ok().build();
    }

}
