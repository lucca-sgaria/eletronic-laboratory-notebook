package br.com.ucs.eln.attachment.business;

import br.com.ucs.eln.attachment.model.Attachment;
import br.com.ucs.eln.attachment.repository.AttachmentRepository;
import br.com.ucs.eln.experiment.model.Experiment;
import br.com.ucs.eln.user.model.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class AttachmentManageBusiness {

    @Inject
    AttachmentRepository repository;

    public void addAttachment(Experiment experiment,
                              User user,
                              String name,
                              String externalLink,
                              byte[] file,
                              String fileName,
                              String extensionType) {
        var attachment = new Attachment();
        attachment.setName(name);
        attachment.setCreator(user);
        attachment.setExternalLink(externalLink);
        attachment.setFile(file);
        attachment.setExperiment(experiment);
        attachment.setFileName(fileName);
        attachment.setExtensionType(extensionType);

        repository.persist(attachment);
    }

    public void delete(Long id) {
        repository.delete(repository.findById(id));
    }


}
