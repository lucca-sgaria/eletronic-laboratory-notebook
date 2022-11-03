package br.com.ucs.eln.project.ws;

import br.com.ucs.eln.project.exception.ProjectException;
import br.com.ucs.eln.project.facade.ProjectFacade;
import br.com.ucs.eln.project.model.Project;
import br.com.ucs.eln.project.ws.flag.ProjectAddError;
import br.com.ucs.eln.project.ws.flag.ProjectGetError;
import br.com.ucs.eln.project.ws.flag.ProjectUpdateError;
import br.com.ucs.eln.project.ws.mapper.ProjectResourceMapper;
import br.com.ucs.eln.project.ws.request.ProjectAddRequest;
import br.com.ucs.eln.project.ws.request.ProjectUpdateRequest;
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

@Path("projects")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProjectResource {

    @Inject
    ProjectFacade facade;
    @Inject
    ProjectResourceMapper resourceMapper;

    @GET
    @Path("/count")
    public Response totalProjectsCount(@RestQuery long userId) {
        var totalCount = facade.totalProjectsCount(userId);
        return ApiResponseBuilder.ok(resourceMapper.mapToTotalProjectsCountResponse(totalCount));
    }

    @GET
    public Response listProjects(@RestQuery int page,
                                 @RestQuery int pageSize,
                                 @RestQuery long userId) {
        var projectList = facade.listProjects(page, pageSize, userId);
        return ApiResponseBuilder.ok(resourceMapper.mapToListProjectsResponse(projectList, userId));
    }


    @GET
    @Path("/search")
    public Response searchProjects(@RestQuery String searchKey,
                                   @RestQuery int page,
                                   @RestQuery int pageSize,
                                   @RestQuery long userId) {
        var projectList = facade.searchProjects(page, pageSize, searchKey, userId);
        return ApiResponseBuilder.ok(resourceMapper.mapToSearchProjectsResponse(projectList, userId));
    }

    @GET
    @Path("/search-count")
    public Response searchProjectsCount(@RestQuery String searchKey, @RestQuery long userId) {
        var totalCount = facade.searchProjectsCount(searchKey, userId);
        return ApiResponseBuilder.ok(resourceMapper.mapToSearchProjectsCountResponse(totalCount));
    }

    @POST
    public Response addProject(ProjectAddRequest request) {
        //System.out.println(request.toString());
        try {
            facade.addProject(
                    request.getTitle(),
                    request.getDescription(),
                    request.getState(),
                    request.isOnlyProjectUsers(),
                    request.getProjectUsers()
            );
            return ApiResponseBuilder.ok();
        } catch (Exception e) {
            return ApiResponseBuilder.error(ProjectAddError.resolve(e));
        }
    }

    @GET
    @Path("/{id}")
    public Response getProject(Long id) {
        try {
            Project project = facade.getProject(id);
            return ApiResponseBuilder.ok(resourceMapper.mapToProjectGetResponse(project));
        } catch (ProjectException e) {
            return ApiResponseBuilder.error(ProjectGetError.resolve(e));
        }
    }

    @PUT
    @Path("/{id}")
    public Response updateProject(Long id, ProjectUpdateRequest request) {
        //System.out.println(request.toString());
        try {
            facade.updateProject(
                    id,
                    request.getTitle(),
                    request.getDescription(),
                    request.getState(),
                    request.isOnlyProjectUsers(),
                    request.getProjectUsers()
            );
            return ApiResponseBuilder.ok();
        } catch (Exception e) {
            return ApiResponseBuilder.error(ProjectUpdateError.resolve(e));
        }
    }


}
