package br.com.ucs.eln.ws.resource;

import br.com.ucs.eln.group.dto.GroupDto;
import br.com.ucs.eln.group.dto.GroupDtoMapper;
import br.com.ucs.eln.group.facade.GroupFacade;
import br.com.ucs.eln.group.model.Group;
import org.jboss.resteasy.reactive.RestQuery;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("groups")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GroupResource {

    @Inject
    GroupFacade facade;
    @Inject
    GroupDtoMapper dtoMapper;

    @GET
    public List<GroupDto> list(@RestQuery int page,
                               @RestQuery int pageSize) {
        List<Group> groupList = facade.list(page, pageSize);
        return dtoMapper.map(groupList);
    }

//    @GET
//    @Path("/count")
//    public long count() {
//        return facade.groupsCount();
//    }
//
//    @GET
//    @Path("/pages")
//    public int pageCount(@RestQuery int pageSize) {
//        return facade.pageCount(pageSize);
//    }
//
//    @GET
//    @Path("/search")
//    public List<GroupDto> search(@RestQuery String searchKey,
//                                @RestQuery int page,
//                                @RestQuery int pageSize) {
//        List<Group> groupList = facade.partialSearch(searchKey, page, pageSize);
//        return dtoMapper.map(groupList);
//    }
//
//    @GET
//    @Path("/{id}")
//    public GroupDto get(Long id) throws GroupException {
//        Group group = facade.findById(id);
//        return dtoMapper.map(group);
//    }
//
//    @PUT
//    @Path("/{id}")
//    public GroupDto update(Long id, GroupDto GroupDto) throws GroupException {
//        Group group = facade.update(id, GroupDto);
//        return dtoMapper.map(group);
//    }
//
//    @DELETE
//    @Path("/{id}")
//    public Response delete(Long id) throws GroupException {
//        facade.delete(id);
//        return Response.ok().build();
//    }
//
//    @ServerExceptionMapper
//    public RestResponse<String> mapException(GroupException ex) {
//        return switch (ex.getKey()) {
//            case GROUP_NOT_FOUND -> RestResponse.status(Response.Status.NOT_FOUND, ex.toString());
//        };
//    }

}
