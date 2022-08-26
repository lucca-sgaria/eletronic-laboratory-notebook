package br.com.ucs.eln.group.repository;

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

//    public int pageCount(int pageSize) {
//        return findAll()
//                .page(Page.ofSize(pageSize))
//                .pageCount();
//    }
//
//    public List<User> partialSearch(String searchKey, int page, int pageSize) {
//        String query = "lower(fullName) LIKE ?1 " +
//                " OR lower(username) LIKE ?1 " +
//                " OR lower(email) LIKE ?1 ";
//
//        return find(query, searchKey.toLowerCase() + "%" )
//                .page(Page.of(page, pageSize))
//                .list();
//    }
//
//    public User findExistingById(Long id) throws UserException {
//        User user = findById(id);
//        if (user == null) {
//            throw new UserException(UserExceptionKey.USER_NOT_FOUND);
//        }
//        return user;
//    }
//
//    public User updateUserFields(User user, UserDto userDto) {
//        user.setFullName(userDto.getFullName());
//        user.setLock(getLock(userDto.getLock()));
//        user.setEmail(userDto.getEmail());
//        user.setCreated(userDto.getCreated());
//        user.setUsername(userDto.getUsername());
//        user.setDescription(userDto.getDescription());
//        user.setImage(userDto.getImage());
//        return user;
//    }
//
//    private UserLock getLock(UserLockDto lock) {
//        return switch (lock) {
//            case LOCKED -> UserLock.LOCKED;
//            case UNLOCKED -> UserLock.UNLOCKED;
//            case PENDING -> UserLock.PENDING;
//        };
//    }


}
