package br.com.ucs.eln.comment.ws.response;

import br.com.ucs.eln.comment.ws.model.CommentPayload;
import br.com.ucs.eln.ws.response.ApiResponse;

import java.util.List;

public class CommentListResponse extends ApiResponse {
    private List<CommentPayload> commentList;

    public CommentListResponse(List<CommentPayload> commentList) {
        this.commentList = commentList;
    }

    public List<CommentPayload> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentPayload> commentList) {
        this.commentList = commentList;
    }
}
