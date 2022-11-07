package br.com.ucs.eln.comment.facade;

import br.com.ucs.eln.comment.business.CommentManageBusiness;
import br.com.ucs.eln.comment.model.Comment;
import br.com.ucs.eln.experiment.exception.ExperimentException;
import br.com.ucs.eln.experiment.repository.ExperimentRepository;
import br.com.ucs.eln.user.exception.UserException;
import br.com.ucs.eln.user.repository.UserRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
public class CommentFacade {

    @Inject
    UserRepository userRepository;
    @Inject
    ExperimentRepository experimentRepository;
    @Inject
    CommentManageBusiness manageBusiness;

    public long commentsCount(long experimentId) throws ExperimentException {
        var experiment = experimentRepository.findExistingById(experimentId);
        return experiment.getComments().size();
    }

    public List<Comment> listComments(long experimentId) throws ExperimentException {
        var experiment = experimentRepository.findExistingById(experimentId);
        return experiment.getComments();
    }

    @Transactional
    public void addComment(long experimentId,
                           long userId,
                           String content) throws UserException, ExperimentException {
        var user = userRepository.findExistingById(userId);
        var experiment = experimentRepository.findExistingById(experimentId);

        manageBusiness.addComment(experiment, user, content);
    }

    @Transactional
    public void deleteComment(Long id) {
        manageBusiness.delete(id);
    }

}
