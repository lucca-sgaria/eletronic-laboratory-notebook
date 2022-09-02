package br.com.ucs.eln.user.repository;

import br.com.ucs.eln.user.dto.UserDto;
import br.com.ucs.eln.user.dto.UserLockDto;
import br.com.ucs.eln.user.exception.UserException;
import br.com.ucs.eln.user.exception.UserExceptionKey;
import br.com.ucs.eln.user.model.User;
import br.com.ucs.eln.user.model.UserLock;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

    public boolean existsByEmail(String email) {
        return find("email = ?1", email)
                .firstResultOptional()
                .isPresent();
    }

    public User findExistingByEmail(String email) throws UserException {
        try {
            return find("email = ?1", email).singleResult();
        } catch (NoResultException ex) {
            throw new UserException(UserExceptionKey.USER_NOT_FOUND);
        }
    }

    public List<User> list(int page, int pageSize) {
        return findAll(Sort.by("id"))
                .page(Page.of(page, pageSize))
                .list();
    }

    public int pageCount(int pageSize) {
        return findAll()
                .page(Page.ofSize(pageSize))
                .pageCount();
    }

    public List<User> partialSearch(String searchKey, int page, int pageSize) {
        String query = "lower(fullName) LIKE ?1 " +
                " OR lower(username) LIKE ?1 " +
                " OR lower(email) LIKE ?1 ";

        return find(query, searchKey.toLowerCase() + "%" )
                .page(Page.of(page, pageSize))
                .list();
    }

    public User findExistingById(Long id) throws UserException {
        User user = findById(id);
        if (user == null) {
            throw new UserException(UserExceptionKey.USER_NOT_FOUND);
        }
        return user;
    }

    public List<User> findExistingByIdList(List<Long> idList) throws UserException {
        if(idList.isEmpty()) return new ArrayList<>();

        List<User> userList = find("id in (?1)", idList).list();
        if(userList.size() != idList.size()) {
            throw new UserException(UserExceptionKey.USER_NOT_FOUND);
        }
        return userList;
    }

    public User updateUserFields(User user, UserDto userDto) {
        user.setFullName(userDto.getFullName());
        user.setLock(getLock(userDto.getLock()));
        user.setEmail(userDto.getEmail());
        user.setCreated(userDto.getCreated());
        user.setUsername(userDto.getUsername());
        user.setDescription(userDto.getDescription());
        user.setImage(userDto.getImage());
        return user;
    }

    private UserLock getLock(UserLockDto lock) {
        return switch (lock) {
            case LOCKED -> UserLock.LOCKED;
            case UNLOCKED -> UserLock.UNLOCKED;
            case PENDING -> UserLock.PENDING;
        };
    }


}
