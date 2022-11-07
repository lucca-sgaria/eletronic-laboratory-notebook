package br.com.ucs.eln.attachment.ws.mapper;

import br.com.ucs.eln.attachment.model.Attachment;
import br.com.ucs.eln.attachment.ws.model.AttachmentPayload;
import br.com.ucs.eln.globals.DateUtil;

import javax.enterprise.context.RequestScoped;
import java.time.LocalDateTime;
import java.util.List;

@RequestScoped
public class AttachmentPayloadMapper {

    public List<AttachmentPayload> map(List<Attachment> attachmentList) {
        return attachmentList
                .stream()
                .map(this::map)
                .toList();
    }

    public AttachmentPayload map(Attachment attachment) {
        var payload = new AttachmentPayload();
        payload.setId(attachment.getId());
        payload.setCreatorName(attachment.getCreator().getFullName());
        payload.setCreationDate(formatDate(attachment.getCreated()));
        payload.setCreatorName(attachment.getCreator().getFullName());
        payload.setExternalLink(attachment.getExternalLink());
        payload.setName(attachment.getName());
        payload.setFile(attachment.getFile());
        payload.setFileName(attachment.getFileName());

        return payload;
    }

    private static String formatDate(LocalDateTime date) {
        if (date == null) return null;

        return DateUtil.formatDate(date);
    }

}
