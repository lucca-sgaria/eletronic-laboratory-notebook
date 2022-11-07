package br.com.ucs.eln.project.repository;

import br.com.ucs.eln.project.exception.ProjectException;
import br.com.ucs.eln.project.exception.ProjectExceptionKey;
import br.com.ucs.eln.project.model.Project;
import br.com.ucs.eln.user.model.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ProjectRepository implements PanacheRepository<Project> {

    @Inject
    EntityManager manager;

    public long countProjects(User user) {
        String hql = "SELECT COUNT(DISTINCT pr.id) FROM Project pr " +
                " LEFT JOIN pr.users us WHERE (pr.onlyProjectUsers = false) OR ( :user in (us)) ";

        return manager.createQuery(hql, Long.class)
                .setParameter("user", user)
                .getSingleResult();
    }

    public long countUserProjects(User user) {
        String hql = "SELECT COUNT(DISTINCT pr.id) FROM Project pr " +
                " LEFT JOIN pr.users us WHERE ( :user in (us)) ";

        return manager.createQuery(hql, Long.class)
                .setParameter("user", user)
                .getSingleResult();
    }

    public List<Project> list(int page, int pageSize, User user) {
        String hql = "SELECT DISTINCT(pr) FROM Project pr " +
                " LEFT JOIN pr.users us WHERE (pr.onlyProjectUsers = false)  OR (?1 in (us)) ";

        return find(hql, Sort.by("pr.id"), user)
                .page(Page.of(page, pageSize))
                .list();
    }

    public List<Project> listUserProjects(int page, int pageSize, User user) {
        String hql = "SELECT DISTINCT(pr) FROM Project pr " +
                " LEFT JOIN pr.users us WHERE ?1 in (us) ";

        return find(hql, Sort.by("pr.id"), user)
                .page(Page.of(page, pageSize))
                .list();
    }

    public List<Project> searchProjects(String searchKey, int page, int pageSize, User user) {
        String hql = "SELECT DISTINCT(pr) FROM Project pr " +
                " LEFT JOIN pr.users us WHERE (pr.onlyProjectUsers = false) OR (?1 in (us)) " +
                " AND ( lower(number) LIKE ?2 OR lower(title) LIKE ?2) ";

        return find(hql, Sort.by("pr.id"), user, "%" + searchKey.toLowerCase() + "%")
                .page(Page.of(page, pageSize))
                .list();
    }

    public List<Project> searchUserProjects(String searchKey, int page, int pageSize, User user) {
        String hql = "SELECT DISTINCT(pr) FROM Project pr " +
                " LEFT JOIN pr.users us WHERE (?1 in (us)) " +
                " AND ( lower(number) LIKE ?2 OR lower(title) LIKE ?2) ";

        return find(hql, Sort.by("pr.id"), user, "%" + searchKey.toLowerCase() + "%")
                .page(Page.of(page, pageSize))
                .list();
    }

    public long searchCount(String searchKey, User user) {
        String hql = "SELECT COUNT(DISTINCT pr.id) FROM Project pr " +
                " LEFT JOIN pr.users us WHERE (pr.onlyProjectUsers = false) OR ( :user in (us)) " +
                " AND ( lower(pr.number) LIKE :searchKey OR lower(pr.title) LIKE :searchKey)";

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

    public Project findExistingById(Long id) throws ProjectException {
        var project = findById(id);
        if (project == null) {
            throw new ProjectException(ProjectExceptionKey.PROJECT_NOT_FOUND);
        }
        return project;
    }

}
