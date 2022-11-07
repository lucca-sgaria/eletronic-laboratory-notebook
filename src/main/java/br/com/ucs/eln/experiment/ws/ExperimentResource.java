package br.com.ucs.eln.experiment.ws;

import br.com.ucs.eln.experiment.exception.ExperimentException;
import br.com.ucs.eln.experiment.facade.ExperimentFacade;
import br.com.ucs.eln.experiment.model.Experiment;
import br.com.ucs.eln.experiment.ws.flag.ExperimentAddError;
import br.com.ucs.eln.experiment.ws.flag.ExperimentGetError;
import br.com.ucs.eln.experiment.ws.flag.ExperimentUpdateError;
import br.com.ucs.eln.experiment.ws.mapper.ExperimentResourceMapper;
import br.com.ucs.eln.experiment.ws.request.ExperimentAddRequest;
import br.com.ucs.eln.experiment.ws.request.ExperimentUpdateRequest;
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
import java.util.Arrays;

@Path("experiments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExperimentResource {

    @Inject
    ExperimentFacade facade;
    @Inject
    ExperimentResourceMapper resourceMapper;

    @GET
    @Path("/count")
    public Response totalExperimentsCount(@RestQuery long userId) {
        var totalCount = facade.totalExperimentsCount(userId);
        return ApiResponseBuilder.ok(resourceMapper.mapToTotalExperimentsCountResponse(totalCount));
    }

    @GET
    public Response listExperiments(@RestQuery int page,
                                    @RestQuery int pageSize,
                                    @RestQuery long userId) {
        var experimentList = facade.listExperiments(page, pageSize, userId);
        return ApiResponseBuilder.ok(resourceMapper.mapToListExperimentsResponse(experimentList, userId));
    }


    @GET
    @Path("/search")
    public Response searchExperiments(@RestQuery String searchKey,
                                      @RestQuery int page,
                                      @RestQuery int pageSize,
                                      @RestQuery long userId) {
        var experimentList = facade.searchExperiments(page, pageSize, searchKey, userId);
        return ApiResponseBuilder.ok(resourceMapper.mapToSearchExperimentsResponse(experimentList, userId));
    }

    @GET
    @Path("/search-count")
    public Response searchExperimentsCount(@RestQuery String searchKey,
                                           @RestQuery long userId) {
        var totalCount = facade.searchExperimentsCount(searchKey, userId);
        return ApiResponseBuilder.ok(resourceMapper.mapToSearchExperimentsCountResponse(totalCount));
    }

    @POST
    public Response addExperiment(ExperimentAddRequest request) {
        try {
            facade.addExperiment(
                    request.getName(),
                    request.getDescription(),
                    request.getCreatorId(),
                    request.getMainImage(),
                    request.getProjectId()
            );
            return ApiResponseBuilder.ok();
        } catch (Exception e) {
            return ApiResponseBuilder.error(ExperimentAddError.resolve(e));
        }
    }

    @GET
    @Path("/{id}")
    public Response getExperiment(Long id) {
        try {
            Experiment experiment = facade.getExperiment(id);
            return ApiResponseBuilder.ok(resourceMapper.mapToExperimentGetResponse(experiment));
        } catch (ExperimentException e) {
            return ApiResponseBuilder.error(ExperimentGetError.resolve(e));
        }
    }

    @PUT
    @Path("/{id}")
    public Response updateExperiment(Long id, ExperimentUpdateRequest request) {
        System.out.println(request.toString());
        try {
            facade.updateExperiment(
                    id,
                    request.getName(),
                    request.getDescription(),
                    request.getMainImage()
            );
            return ApiResponseBuilder.ok();
        } catch (Exception e) {
            return ApiResponseBuilder.error(ExperimentUpdateError.resolve(e));
        }
    }
}
