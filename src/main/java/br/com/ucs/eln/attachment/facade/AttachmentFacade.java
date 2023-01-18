package br.com.ucs.eln.attachment.facade;

import br.com.ucs.eln.attachment.business.AttachmentManageBusiness;
import br.com.ucs.eln.attachment.model.Attachment;
import br.com.ucs.eln.experiment.exception.ExperimentException;
import br.com.ucs.eln.experiment.repository.ExperimentRepository;
import br.com.ucs.eln.user.exception.UserException;
import br.com.ucs.eln.user.repository.UserRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
public class AttachmentFacade {

    @Inject
    UserRepository userRepository;
    @Inject
    ExperimentRepository experimentRepository;
    @Inject
    AttachmentManageBusiness manageBusiness;

    public List<Attachment> listAttachments(long experimentId) throws ExperimentException {
        var experiment = experimentRepository.findExistingById(experimentId);
        return experiment.getAttachments();
    }

    @Transactional
    public void addAttachment(long experimentId,
                              long userId,
                              String name,
                              String externalLink,
                              byte[] file,
                              String fileName,
                              String extensionType) throws UserException, ExperimentException {

        var user = userRepository.findExistingById(userId);
        var experiment = experimentRepository.findExistingById(experimentId);

        manageBusiness.addAttachment(experiment, user, name, externalLink, file, fileName, extensionType);
    }

    @Transactional
    public void deleteAttachment(Long id) {
        manageBusiness.delete(id);
    }


}
