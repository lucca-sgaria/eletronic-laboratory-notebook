package br.com.ucs.eln.group.facade;

import br.com.ucs.eln.group.dto.GroupDto;
import br.com.ucs.eln.group.exception.GroupException;
import br.com.ucs.eln.group.generator.GroupGenerator;
import br.com.ucs.eln.group.model.Group;
import br.com.ucs.eln.group.repository.GroupRepository;
import br.com.ucs.eln.user.exception.UserException;
import br.com.ucs.eln.user.model.User;
import br.com.ucs.eln.user.repository.UserRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
public class GroupFacade {

    @Inject
    GroupRepository groupRepository;
    @Inject
    UserRepository userRepository;
    @Inject
    GroupGenerator groupGenerator;

    @Transactional
    public Group create(GroupDto groupDto) throws GroupException {
        return groupGenerator.generate(groupDto);
    }

    public List<Group> list(int page, int pageSize) {
        return groupRepository.list(page, pageSize);
    }

    public int pageCount(int pageSize) {
        return groupRepository.pageCount(pageSize);
    }

    public long groupsCount() {
        return groupRepository.count();
    }

    public List<Group> partialSearch(String searchKey, int page, int pageSize) {
        return groupRepository.partialSearch(searchKey, page, pageSize);
    }

    public Group findById(Long id) throws GroupException {
        return groupRepository.findExistingById(id);
    }

    @Transactional
    public Group update(Long id, GroupDto groupDto) throws GroupException {
        var group = groupRepository.findExistingById(id);
        return groupRepository.updateGroupFields(
                group,
                groupDto
        );
    }

    @Transactional
    public void delete(Long id) throws GroupException {
        var group = groupRepository.findExistingById(id);
        groupRepository.delete(group);
    }

    public List<User> listGroupUsers(Long id) throws GroupException {
        var group = groupRepository.findExistingById(id);
        return group.getUsers();
    }

    @Transactional
    public void updateGroupUsers(Long id, List<Long> userIdList) throws GroupException, UserException {
        var group = groupRepository.findExistingById(id);
        var userList = userRepository.findExistingByIdList(userIdList);

        groupRepository.updateGroupUsers(
                group,
                userList
        );
    }


}
