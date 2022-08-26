package br.com.ucs.eln.group.facade;

import br.com.ucs.eln.group.model.Group;
import br.com.ucs.eln.group.repository.GroupRepository;
import br.com.ucs.eln.user.generator.UserGenerator;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class GroupFacade {

    @Inject
    GroupRepository groupRepository;

    public List<Group> list(int page, int pageSize) {
        return groupRepository.list(page, pageSize);
    }

//    public int pageCount(int pageSize) {
//        return userRepository.pageCount(pageSize);
//    }
//
//    public long groupsCount() {
//        return userRepository.count();
//    }
//
//    public List<User> partialSearch(String searchKey, int page, int pageSize) {
//        return userRepository.partialSearch(searchKey, page, pageSize);
//    }
//
//    public User findById(Long id) throws UserException {
//        return userRepository.findExistingById(id);
//    }
//
//    @Transactional
//    public User update(Long id, UserDto userDto) throws UserException {
//        var user = userRepository.findExistingById(id);
//        return userRepository.updateUserFields(
//                user,
//                userDto
//        );
//    }
//
//    @Transactional
//    public void delete(Long id) throws UserException {
//        User user = userRepository.findExistingById(id);
//        userRepository.delete(user);
//    }
//
//    public User findByEmail(String email) throws UserException {
//        return userRepository.findExistingByEmail(email);
//    }
}
