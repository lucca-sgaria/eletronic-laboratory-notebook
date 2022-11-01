package br.com.ucs.eln.group.ws;

import br.com.ucs.eln.group.exception.GroupException;
import br.com.ucs.eln.group.facade.GroupFacade;
import br.com.ucs.eln.group.model.Group;
import br.com.ucs.eln.group.ws.flag.GroupAddError;
import br.com.ucs.eln.group.ws.flag.GroupGetError;
import br.com.ucs.eln.group.ws.flag.GroupUpdateError;
import br.com.ucs.eln.group.ws.mapper.GroupResourceMapper;
import br.com.ucs.eln.group.ws.request.GroupAddRequest;
import br.com.ucs.eln.group.ws.request.GroupUpdateRequest;
import br.com.ucs.eln.ws.response.ApiResponseBuilder;
import org.jboss.resteasy.reactive.RestQuery;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("groups")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GroupResource {

    @Inject
    GroupFacade facade;
    @Inject
    GroupResourceMapper resourceMapper;

    @GET
    @Path("/count")
    public Response totalGroupsCount() {
        long totalCount = facade.totalUsersCount();
        return ApiResponseBuilder.ok(resourceMapper.mapToTotalGroupsCountResponse(totalCount));
    }

    @GET
    public Response listGroups(@RestQuery int page,
                               @RestQuery int pageSize) {
        List<Group> groupList = facade.listGroups(page, pageSize);
        return ApiResponseBuilder.ok(resourceMapper.mapToListGroupsResponse(groupList));
    }

    @GET
    @Path("/list-resumed")
    public Response listGroupsResumed() {
        List<Group> groupList = facade.listGroups();
        return ApiResponseBuilder.ok(resourceMapper.mapToListGroupsResumedResponse(groupList));
    }

    @GET
    @Path("/search")
    public Response searchGroup(@RestQuery String searchKey,
                                @RestQuery int page,
                                @RestQuery int pageSize) {
        List<Group> groupList = facade.searchGroups(page, pageSize, searchKey);
        return ApiResponseBuilder.ok(resourceMapper.mapToSearchGroupsResponse(groupList));
    }

    @GET
    @Path("/search-count")
    public Response searchGroupCount(@RestQuery String searchKey) {
        long totalCount = facade.searchUsersCount(searchKey);
        return ApiResponseBuilder.ok(resourceMapper.mapToSearchGroupsCountResponse(totalCount));
    }

    @POST
    public Response addGroup(GroupAddRequest request) {
        try {
            facade.addGroup(
                    request.getName(),
                    request.getDescription(),
                    request.getAllowedFunctions(),
                    request.isAdmin()
            );
            return ApiResponseBuilder.ok();
        } catch (GroupException e) {
            return ApiResponseBuilder.error(GroupAddError.resolve(e));
        }
    }

    @GET
    @Path("/{id}")
    public Response getGroup(Long id) {
        try {
            Group group = facade.getGroup(id);
            return ApiResponseBuilder.ok(resourceMapper.mapToGroupGetResponse(group));
        } catch (GroupException e) {
            return ApiResponseBuilder.error(GroupGetError.resolve(e));
        }
    }

    @PUT
    @Path("/{id}")
    public Response updateGroup(Long id, GroupUpdateRequest request) {
        try {
            facade.updateGroup(
                    id,
                    request.getName(),
                    request.getDescription(),
                    request.getAllowedFunctions(),
                    request.isAdmin()
            );
            return ApiResponseBuilder.ok();
        } catch (GroupException e) {
            return ApiResponseBuilder.error(GroupUpdateError.resolve(e));
        }
    }


}
