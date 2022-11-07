package br.com.ucs.eln.experiment.repository;

import br.com.ucs.eln.experiment.exception.ExperimentException;
import br.com.ucs.eln.experiment.exception.ExperimentExceptionKey;
import br.com.ucs.eln.experiment.model.Experiment;
import br.com.ucs.eln.user.model.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ExperimentRepository implements PanacheRepository<Experiment> {

    @Inject
    EntityManager manager;

    public long countExperiments(User user) {
        String hql = "SELECT COUNT(DISTINCT ex.id) FROM Experiment ex" +
                " INNER JOIN ex.project pr " +
                " LEFT JOIN pr.users us " +
                " WHERE (pr.onlyProjectUsers = false) OR (:user in (us)) ";

        return manager.createQuery(hql, Long.class)
                .setParameter("user", user)
                .getSingleResult();
    }

    public long countUserExperiments(User user) {
        String hql = "SELECT COUNT(DISTINCT ex.id) FROM Experiment ex" +
                " INNER JOIN ex.project pr" +
                " LEFT JOIN pr.users us " +
                " WHERE (:user in (us)) ";

        return manager.createQuery(hql, Long.class)
                .setParameter("user", user)
                .getSingleResult();
    }

    public List<Experiment> list(int page, int pageSize, User user) {
        String hql = "SELECT DISTINCT(ex) FROM Experiment ex " +
                " INNER JOIN ex.project pr" +
                " LEFT JOIN pr.users us " +
                " WHERE (pr.onlyProjectUsers = false) OR ?1 in (us) ";

        return find(hql, Sort.by("ex.id"), user)
                .page(Page.of(page, pageSize))
                .list();
    }

    public List<Experiment> listUserExperiments(int page, int pageSize, User user) {
        String hql = "SELECT DISTINCT(ex) FROM Experiment ex " +
                " INNER JOIN ex.project pr " +
                " LEFT JOIN pr.users us " +
                " WHERE ?1 in (us) ";

        return find(hql, Sort.by("ex.id"), user)
                .page(Page.of(page, pageSize))
                .list();
    }

    public List<Experiment> searchExperiments(String searchKey, int page, int pageSize, User user) {
        String hql = "SELECT DISTINCT(ex) FROM Experiment ex " +
                " INNER JOIN ex.project pr " +
                " LEFT JOIN pr.users us " +
                " WHERE (pr.onlyProjectUsers = false OR ?1 in (us)) " +
                " AND (lower(ex.number) LIKE ?2 OR lower(ex.name) LIKE ?2 " +
                " OR lower(pr.number) LIKE ?2 OR lower(pr.title) LIKE ?2 )";

        return find(hql, Sort.by("ex.id"), user, "%" + searchKey.toLowerCase() + "%")
                .page(Page.of(page, pageSize))
                .list();
    }

    public List<Experiment> searchUserExperiments(String searchKey, int page, int pageSize, User user) {
        String hql = "SELECT DISTINCT(ex) FROM Experiment ex " +
                " INNER JOIN ex.project pr " +
                " LEFT JOIN pr.users us " +
                " WHERE ?1 in (us) " +
                " AND (lower(ex.number) LIKE ?2 OR lower(ex.name) LIKE ?2 " +
                " OR lower(pr.number) LIKE ?2 OR lower(pr.title) LIKE ?2) ";

        return find(hql, Sort.by("ex.id"), user, "%" + searchKey.toLowerCase() + "%")
                .page(Page.of(page, pageSize))
                .list();
    }

    public long searchCount(String searchKey, User user) {
        System.out.println("searchCount " + searchKey);
        String hql = "SELECT COUNT(DISTINCT ex.id) FROM Experiment ex" +
                " INNER JOIN ex.project pr " +
                " LEFT JOIN pr.users us " +
                " WHERE ((pr.onlyProjectUsers = false) OR (:user in (us)))" +
                " AND (lower(ex.number) LIKE lower(:searchKey) OR lower(ex.name) LIKE lower(:searchKey) " +
                " OR lower(pr.number) LIKE lower(:searchKey) OR lower(pr.title) LIKE lower(:searchKey)) ";

        return manager.createQuery(hql, Long.class)
                .setParameter("user", user)
                .setParameter("searchKey", searchKey)
                .getSingleResult();
    }

    public long searchCountUser(String searchKey, User user) {
        System.out.println("searchCountUser");
        String hql = "SELECT COUNT(DISTINCT ex.id) FROM Experiment ex" +
                " INNER JOIN ex.project pr " +
                " LEFT JOIN pr.users us " +
                " WHERE (:user in (us))" +
                " AND (lower(ex.number) LIKE lower(:searchKey) OR lower(ex.name) LIKE lower(:searchKey) " +
                " OR lower(pr.number) LIKE lower(:searchKey) OR lower(pr.title) LIKE lower(:searchKey)) ";

        return manager.createQuery(hql, Long.class)
                .setParameter("user", user)
                .setParameter("searchKey", searchKey)
                .getSingleResult();
    }

    public boolean existsByNumber(String number) {
        return find("number = ?1", number)
                .firstResultOptional()
                .isPresent();
    }

    public Experiment findExistingById(Long id) throws ExperimentException {
        var experiment = findById(id);
        if (experiment == null) {
            throw new ExperimentException(ExperimentExceptionKey.EXPERIMENT_NOT_FOUND);
        }
        return experiment;
    }

}
