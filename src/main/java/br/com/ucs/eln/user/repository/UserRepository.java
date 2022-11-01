package br.com.ucs.eln.user.repository;

import br.com.ucs.eln.user.exception.UserException;
import br.com.ucs.eln.user.exception.UserExceptionKey;
import br.com.ucs.eln.user.model.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

    public User findByEmail(String email) throws UserException {
        try {
            return find("email = ?1", email).singleResult();
        } catch (NoResultException ex) {
            throw new UserException(UserExceptionKey.USER_NOT_FOUND);
        }
    }

    public boolean existsByEmail(String email) {
        return find("email = ?1", email)
                .firstResultOptional()
                .isPresent();
    }

    public User findExistingById(Long id) throws UserException {
        User user = findById(id);
        if (user == null) {
            throw new UserException(UserExceptionKey.USER_NOT_FOUND);
        }
        return user;
    }

    public int totalPages(int pageSize) {
        return findAll()
                .page(Page.ofSize(pageSize))
                .pageCount();
    }

    public List<User> list(int page, int pageSize) {
        return findAll(Sort.by("id"))
                .page(Page.of(page, pageSize))
                .list();
    }

    public List<User> searchUsers(String searchKey, int page, int pageSize) {
        String query = "lower(fullName) LIKE ?1 " +
                " OR lower(username) LIKE ?1 " +
                " OR lower(email) LIKE ?1 ";

        return find(query, Sort.by("id"), "%" + searchKey.toLowerCase() + "%")
                .page(Page.of(page, pageSize))
                .list();
    }

    public long searchCount(String searchKey) {
        String query = "lower(fullName) LIKE ?1 " +
                " OR lower(username) LIKE ?1 " +
                " OR lower(email) LIKE ?1 ";

        return find(query, "%" + searchKey.toLowerCase() + "%")
                .count();
    }

// ----------------------------------------------------------------

    public List<User> findExistingByIdList(List<Long> idList) throws UserException {
        if (idList.isEmpty()) return new ArrayList<>();

        List<User> userList = find("id in (?1)", idList).list();
        if (userList.size() != idList.size()) {
            throw new UserException(UserExceptionKey.USER_NOT_FOUND);
        }
        return userList;
    }

}
