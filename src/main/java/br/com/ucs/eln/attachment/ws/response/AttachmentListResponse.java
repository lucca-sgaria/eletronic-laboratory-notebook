package br.com.ucs.eln.attachment.ws.response;

import br.com.ucs.eln.attachment.ws.model.AttachmentPayload;
import br.com.ucs.eln.ws.response.ApiResponse;

import java.util.List;
import java.util.stream.Collectors;

public class AttachmentListResponse extends ApiResponse {
    private List<AttachmentPayload> attachmentList;

    public AttachmentListResponse(List<AttachmentPayload> attachmentList) {
        this.attachmentList = attachmentList;
    }

    public List<AttachmentPayload> getAttachmentList() {
        return attachmentList;
    }

    public void setAttachmentList(List<AttachmentPayload> attachmentList) {
        this.attachmentList = attachmentList;
    }

    @Override
    public String toString() {
        return "AttachmentListResponse{" +
                "attachmentList=" + attachmentList.stream().map(at -> at.toString()).collect(Collectors.joining(",")) +
                '}';
    }
}
