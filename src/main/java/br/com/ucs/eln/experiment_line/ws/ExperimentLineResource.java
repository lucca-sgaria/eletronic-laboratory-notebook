package br.com.ucs.eln.experiment_line.ws;

import br.com.ucs.eln.experiment_line.facade.ExperimentLineFacade;
import br.com.ucs.eln.experiment_line.ws.flag.ExperimentLineAddError;
import br.com.ucs.eln.experiment_line.ws.flag.ExperimentLineListingError;
import br.com.ucs.eln.experiment_line.ws.mapper.ExperimentLineResourceMapper;
import br.com.ucs.eln.experiment_line.ws.request.ExperimentLineAddRequest;
import br.com.ucs.eln.experiment_line.ws.request.ExperimentLineUpdateRequest;
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

@Path("experimentlines")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExperimentLineResource {

    @Inject
    ExperimentLineFacade facade;
    @Inject
    ExperimentLineResourceMapper resourceMapper;

    @GET
    public Response list(@RestQuery long experimentId) {
        try {
            var lineList = facade.listExperimentLines(experimentId);
            return ApiResponseBuilder.ok(resourceMapper.mapToListExperimentLinesResponse(lineList));
        } catch (Exception e) {
            return ApiResponseBuilder.error(ExperimentLineListingError.resolve(e));
        }
    }

    @POST
    public Response add(ExperimentLineAddRequest request) {
        try {
            facade.addExperimentLine(
                    request.getExperimentId(),
                    request.getCompoundId(),
                    request.getAmount(),
                    request.getMoles(),
                    request.getType()
            );
            return ApiResponseBuilder.ok();
        } catch (Exception e) {
            return ApiResponseBuilder.error(ExperimentLineAddError.resolve(e));
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(Long id) {
        facade.deleteExperimentLine(id);
        return ApiResponseBuilder.ok();
    }

    @PATCH
    @Path("/{id}")
    public Response update(Long id, ExperimentLineUpdateRequest request) {
        System.out.println(request);
        facade.updateExperimentLine(
                id,
                request.getAmount(),
                request.getMoles(),
                request.getType()
        );
        return ApiResponseBuilder.ok();
    }
}
