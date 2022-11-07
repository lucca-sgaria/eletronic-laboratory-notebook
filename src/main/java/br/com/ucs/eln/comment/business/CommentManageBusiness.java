package br.com.ucs.eln.comment.business;

import br.com.ucs.eln.comment.model.Comment;
import br.com.ucs.eln.comment.repository.CommentRepository;
import br.com.ucs.eln.experiment.model.Experiment;
import br.com.ucs.eln.user.model.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class CommentManageBusiness {

    @Inject
    CommentRepository repository;

    public void addComment(Experiment experiment,
                           User user,
                           String content) {

        var comment = new Comment();
        comment.setCreator(user);
        comment.setContent(content);
        comment.setExperiment(experiment);

        repository.persist(comment);
    }

    public void delete(Long id) {
        repository.delete(repository.findById(id));
    }
}
