package br.com.ucs.eln.comment.ws.request;

import br.com.ucs.eln.ws.request.Request;

public class CommentAddRequest extends Request {
    private long experimentId;
    private long userId;
    private String content;

    public long getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(long experimentId) {
        this.experimentId = experimentId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
