package br.com.ucs.eln.attachment.ws;

import br.com.ucs.eln.attachment.facade.AttachmentFacade;
import br.com.ucs.eln.attachment.ws.flag.AttachmentAddError;
import br.com.ucs.eln.attachment.ws.flag.AttachmentListingError;
import br.com.ucs.eln.attachment.ws.mapper.AttachmentResourceMapper;
import br.com.ucs.eln.attachment.ws.request.AttachmentAddRequest;
import br.com.ucs.eln.ws.response.ApiResponseBuilder;
import org.jboss.resteasy.reactive.RestQuery;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("attachments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AttachmentResource {

    @Inject
    AttachmentFacade facade;
    @Inject
    AttachmentResourceMapper resourceMapper;

    @GET
    public Response list(@RestQuery long experimentId) {
        try {
            var attachmentList = facade.listAttachments(experimentId);
            return ApiResponseBuilder.ok(resourceMapper.mapToListAttachmentsResponse(attachmentList));
        } catch (Exception e) {
            return ApiResponseBuilder.error(AttachmentListingError.resolve(e));
        }
    }

    @POST
    public Response add(AttachmentAddRequest request) {
        System.out.println(request.toString());
        try {
            facade.addAttachment(
                    request.getExperimentId(),
                    request.getUserId(),
                    request.getName(),
                    request.getExternalLink(),
                    request.getFile(),
                    request.getFileName()
            );
            return ApiResponseBuilder.ok();
        } catch (Exception e) {
            return ApiResponseBuilder.error(AttachmentAddError.resolve(e));
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(Long id) {
        facade.deleteAttachment(id);
        return ApiResponseBuilder.ok();
    }
}
