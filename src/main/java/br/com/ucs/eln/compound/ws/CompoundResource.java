package br.com.ucs.eln.compound.ws;

import br.com.ucs.eln.compound.exception.CompoundException;
import br.com.ucs.eln.compound.facade.CompoundFacade;
import br.com.ucs.eln.compound.model.Compound;
import br.com.ucs.eln.compound.ws.flag.CompoundAddError;
import br.com.ucs.eln.compound.ws.flag.CompoundGetError;
import br.com.ucs.eln.compound.ws.flag.CompoundUpdateError;
import br.com.ucs.eln.compound.ws.mapper.CompoundResourceMapper;
import br.com.ucs.eln.compound.ws.request.CompoundAddRequest;
import br.com.ucs.eln.compound.ws.request.CompoundUpdateRequest;
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

@Path("compounds")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CompoundResource {

    @Inject
    CompoundFacade facade;
    @Inject
    CompoundResourceMapper resourceMapper;

    @GET
    @Path("/count")
    public Response totalCompoundsCount() {
        var totalCount = facade.totalCompoundCount();
        return ApiResponseBuilder.ok(resourceMapper.mapToTotalCompoundsCountResponse(totalCount));
    }

    @GET
    public Response listCompounds(@RestQuery int page,
                                  @RestQuery int pageSize) {
        var compoundList = facade.listCompounds(page, pageSize);
        return ApiResponseBuilder.ok(resourceMapper.mapToListCompoundsResponse(compoundList));
    }

    @GET
    @Path("/search")
    public Response searchCompounds(@RestQuery String searchKey,
                                    @RestQuery int page,
                                    @RestQuery int pageSize) {
        var compoundList = facade.searchCompounds(page, pageSize, searchKey);
        return ApiResponseBuilder.ok(resourceMapper.mapToSearchCompoundsResponse(compoundList));
    }

    @GET
    @Path("/search-count")
    public Response searchCompoundsCount(@RestQuery String searchKey) {
        var totalCount = facade.searchCompoundsCount(searchKey);
        return ApiResponseBuilder.ok(resourceMapper.mapToSearchCompoundsCountResponse(totalCount));
    }

    @POST
    public Response addCompound(CompoundAddRequest request) {
        try {
            facade.addCompound(
                    request.getName(),
                    request.getDescription(),
                    request.getMolarMass(),
                    request.getUnitMeasure()
            );
            return ApiResponseBuilder.ok();
        } catch (CompoundException e) {
            return ApiResponseBuilder.error(CompoundAddError.resolve(e));
        }
    }

    @GET
    @Path("/{id}")
    public Response getCompound(Long id) {
        try {
            Compound compound = facade.getCompound(id);
            return ApiResponseBuilder.ok(resourceMapper.mapToCompoundGetResponse(compound));
        } catch (CompoundException e) {
            return ApiResponseBuilder.error(CompoundGetError.resolve(e));
        }
    }

    @PUT
    @Path("/{id}")
    public Response updateCompound(Long id, CompoundUpdateRequest request) {
        try {
            facade.updateCompound(
                    id,
                    request.getName(),
                    request.getDescription(),
                    request.getMolarMass(),
                    request.getUnitMeasure()
            );
            return ApiResponseBuilder.ok();
        } catch (CompoundException e) {
            return ApiResponseBuilder.error(CompoundUpdateError.resolve(e));
        }
    }

    @GET
    @Path("/list-unit-measure")
    public Response listUnitMeasure() {
        var unitMeasureList = facade.listUnitMeasure();
        return ApiResponseBuilder.ok(resourceMapper.mapToListUnitMeasureResponse(unitMeasureList));
    }
}
