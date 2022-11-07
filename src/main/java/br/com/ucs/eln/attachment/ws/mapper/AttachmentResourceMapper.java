package br.com.ucs.eln.attachment.ws.mapper;

import br.com.ucs.eln.attachment.model.Attachment;
import br.com.ucs.eln.attachment.ws.response.AttachmentListResponse;
import br.com.ucs.eln.user.repository.UserRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class AttachmentResourceMapper {

    @Inject
    AttachmentPayloadMapper payloadMapper;

    public AttachmentListResponse mapToListAttachmentsResponse(List<Attachment> attachmentList) {
        AttachmentListResponse attachmentListResponse = new AttachmentListResponse(payloadMapper.map(attachmentList));
        System.out.println(attachmentListResponse);
        return attachmentListResponse;
    }

}
