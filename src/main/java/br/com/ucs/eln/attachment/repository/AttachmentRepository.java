package br.com.ucs.eln.attachment.repository;

import br.com.ucs.eln.attachment.model.Attachment;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AttachmentRepository implements PanacheRepository<Attachment> {

}
