package br.com.ucs.eln.comment.ws.mapper;

import br.com.ucs.eln.comment.model.Comment;
import br.com.ucs.eln.comment.ws.model.CommentPayload;
import br.com.ucs.eln.globals.DateUtil;
import br.com.ucs.eln.user.model.User;

import javax.enterprise.context.RequestScoped;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RequestScoped
public class CommentPayloadMapper {

    public List<CommentPayload> map(List<Comment> commentList, User user) {
        return commentList
                .stream()
                .map(experiment -> map(experiment, user))
                .toList();
    }

    public CommentPayload map(Comment comment, User user) {
        var payload = new CommentPayload();
        payload.setId(comment.getId());
        payload.setCreatorName(comment.getCreator().getFullName());
        payload.setContent(comment.getContent());
        payload.setCreationDate(formatDate(comment.getCreated()));
        payload.setCreator(Objects.equals(user, comment.getCreator()));

        return payload;
    }

    private static String formatDate(LocalDateTime date) {
        if (date == null) return null;

        return DateUtil.formatDate(date);
    }

}
