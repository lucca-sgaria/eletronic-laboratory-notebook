package br.com.ucs.eln.comment.repository;

import br.com.ucs.eln.comment.model.Comment;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class CommentRepository implements PanacheRepository<Comment> {

}
