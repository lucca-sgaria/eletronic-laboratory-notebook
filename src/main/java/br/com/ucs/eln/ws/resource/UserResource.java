package br.com.ucs.eln.ws.resource;

import br.com.ucs.eln.group.exception.GroupException;
import br.com.ucs.eln.user.dto.UserDto;
import br.com.ucs.eln.user.dto.UserDtoMapper;
import br.com.ucs.eln.user.exception.UserException;
import br.com.ucs.eln.user.facade.UserFacade;
import br.com.ucs.eln.user.model.User;
import br.com.ucs.eln.ws.request.UserLoginRequest;
import br.com.ucs.eln.ws.request.UserRegistrationRequest;
import org.jboss.resteasy.reactive.RestQuery;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserFacade facade;
    @Inject
    UserDtoMapper dtoMapper;

    @POST
    @Path("/register")
    public UserDto registration(UserRegistrationRequest request) throws UserException, GroupException {
        User user = facade.registration(request.getEmail(), request.getGroupId());
        return dtoMapper.map(user);
    }

    //TODO implementar login completo (senha, autenticacao, validação lock)
    @POST
    @Path("/login")
    public UserDto login(UserLoginRequest request) throws UserException {
        User user = facade.findByEmail(request.getEmail());
        return dtoMapper.map(user);
    }

    @GET
    public List<UserDto> list(@RestQuery int page,
                              @RestQuery int pageSize) {
        List<User> userList = facade.list(page, pageSize);
        return dtoMapper.map(userList);
    }

    @GET
    @Path("/count")
    public long count() {
        return facade.usersCount();
    }

    @GET
    @Path("/pages")
    public int pageCount(@RestQuery int pageSize) {
        return facade.pageCount(pageSize);
    }

    @GET
    @Path("/search")
    public List<UserDto> search(@RestQuery String searchKey,
                                @RestQuery int page,
                                @RestQuery int pageSize) {
        List<User> userList = facade.partialSearch(searchKey, page, pageSize);
        return dtoMapper.map(userList);
    }

    @GET
    @Path("/{id}")
    public UserDto get(Long id) throws UserException {
        User user = facade.findById(id);
        return dtoMapper.map(user);
    }

    @PUT
    @Path("/{id}")
    public UserDto update(Long id, UserDto userDto) throws UserException {
        User user = facade.update(id, userDto);
        return dtoMapper.map(user);
    }

    @DELETE
    @Path("/{id}")
    public Response delete(Long id) throws UserException {
        facade.delete(id);
        return Response.ok().build();
    }

}
