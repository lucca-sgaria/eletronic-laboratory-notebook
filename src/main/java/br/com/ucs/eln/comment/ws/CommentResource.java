package br.com.ucs.eln.comment.ws;

import br.com.ucs.eln.comment.facade.CommentFacade;
import br.com.ucs.eln.comment.ws.flag.CommentAddError;
import br.com.ucs.eln.comment.ws.flag.CommentCountError;
import br.com.ucs.eln.comment.ws.flag.CommentListingError;
import br.com.ucs.eln.comment.ws.mapper.CommentResourceMapper;
import br.com.ucs.eln.comment.ws.request.CommentAddRequest;
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

@Path("comments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {

    @Inject
    CommentFacade facade;
    @Inject
    CommentResourceMapper resourceMapper;

    @GET
    @Path("/count")
    public Response count(@RestQuery long experimentId) {
        try {
            var count = facade.commentsCount(experimentId);
            return ApiResponseBuilder.ok(resourceMapper.mapToCommentsCountResponse(count));
        } catch (Exception e) {
            return ApiResponseBuilder.error(CommentCountError.resolve(e));
        }
    }

    @GET
    public Response list(@RestQuery long userId,
                         @RestQuery long experimentId) {
        try {
            var commentList = facade.listComments(experimentId);
            return ApiResponseBuilder.ok(resourceMapper.mapToListCommentsResponse(commentList, userId));
        } catch (Exception e) {
            return ApiResponseBuilder.error(CommentListingError.resolve(e));
        }
    }

    @POST
    public Response add(CommentAddRequest request) {
        System.out.println(request.toString());
        try {
            facade.addComment(
                    request.getExperimentId(),
                    request.getUserId(),
                    request.getContent()
            );
            return ApiResponseBuilder.ok();
        } catch (Exception e) {
            return ApiResponseBuilder.error(CommentAddError.resolve(e));
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(Long id) {
        facade.deleteComment(id);
        return ApiResponseBuilder.ok();
    }
}
