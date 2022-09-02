package br.com.ucs.eln.group.repository;

import br.com.ucs.eln.group.dto.GroupDto;
import br.com.ucs.eln.group.exception.GroupException;
import br.com.ucs.eln.group.exception.GroupExceptionKey;
import br.com.ucs.eln.group.model.Group;
import br.com.ucs.eln.user.model.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class GroupRepository implements PanacheRepository<Group> {

    public boolean existsByName(String name) {
        return find("name = ?1", name)
                .firstResultOptional()
                .isPresent();
    }

    public List<Group> list(int page, int pageSize) {
        return findAll(Sort.by("id"))
                .page(Page.of(page, pageSize))
                .list();
    }

    public int pageCount(int pageSize) {
        return findAll()
                .page(Page.ofSize(pageSize))
                .pageCount();
    }

    public List<Group> partialSearch(String searchKey, int page, int pageSize) {
        String query = "lower(name) LIKE ?1 " +
                " OR lower(description) LIKE ?1 ";

        return find(query, searchKey.toLowerCase() + "%")
                .page(Page.of(page, pageSize))
                .list();
    }

    public Group findExistingById(Long id) throws GroupException {
        var group = findById(id);
        if (group == null) {
            throw new GroupException(GroupExceptionKey.GROUP_NOT_FOUND);
        }
        return group;
    }

    public Group updateGroupFields(Group group, GroupDto groupDto) {
        group.setName(groupDto.getName());
        group.setDescription(groupDto.getDescription());
        group.setAdmin(groupDto.isAdmin());
        //group.setFunctions(groupDto.getFunctions());
        return group;
    }

    public void updateGroupUsers(Group group, List<User> userList) {
        userList.forEach(user -> user.setGroup(group));
    }


}
