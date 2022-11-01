package br.com.ucs.eln.group.repository;

import br.com.ucs.eln.group.exception.GroupException;
import br.com.ucs.eln.group.exception.GroupExceptionKey;
import br.com.ucs.eln.group.model.Group;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class GroupRepository implements PanacheRepository<Group> {

    public List<Group> list(int page, int pageSize) {
        return findAll(Sort.by("id"))
                .page(Page.of(page, pageSize))
                .list();
    }

    public List<Group> list() {
        return findAll(Sort.by("id"))
                .list();
    }

    public List<Group> searchGroups(String searchKey, int page, int pageSize) {
        String query = "lower(name) LIKE ?1 " +
                " OR lower(description) LIKE ?1 ";

        return find(query, Sort.by("id"), "%" + searchKey.toLowerCase() + "%")
                .page(Page.of(page, pageSize))
                .list();
    }

    public long searchCount(String searchKey) {
        String query = "lower(name) LIKE ?1 " +
                " OR lower(description) LIKE ?1 ";

        return find(query, "%" + searchKey.toLowerCase() + "%")
                .count();
    }

    public boolean existsByName(String name) {
        return find("name = ?1", name)
                .firstResultOptional()
                .isPresent();
    }


    public Group findExistingById(Long id) throws GroupException {
        var group = findById(id);
        if (group == null) {
            throw new GroupException(GroupExceptionKey.GROUP_NOT_FOUND);
        }
        return group;
    }
}
