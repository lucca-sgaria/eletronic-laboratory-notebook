package br.com.ucs.eln.comment.ws.mapper;

import br.com.ucs.eln.comment.model.Comment;
import br.com.ucs.eln.comment.ws.response.CommentCountResponse;
import br.com.ucs.eln.comment.ws.response.CommentListResponse;
import br.com.ucs.eln.user.repository.UserRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class CommentResourceMapper {

    @Inject
    CommentPayloadMapper payloadMapper;
    @Inject
    UserRepository userRepository;

    public CommentCountResponse mapToCommentsCountResponse(long totalCount) {
        return new CommentCountResponse(totalCount);
    }

    public CommentListResponse mapToListCommentsResponse(List<Comment> experimentList, long userId) {
        var user = userRepository.findById(userId);
        return new CommentListResponse(payloadMapper.map(experimentList, user));
    }

}
