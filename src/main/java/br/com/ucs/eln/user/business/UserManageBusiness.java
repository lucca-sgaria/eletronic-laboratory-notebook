package br.com.ucs.eln.user.business;

import br.com.ucs.eln.globals.MD5Util;
import br.com.ucs.eln.globals.StringUtil;
import br.com.ucs.eln.group.exception.GroupException;
import br.com.ucs.eln.group.model.Group;
import br.com.ucs.eln.group.repository.GroupRepository;
import br.com.ucs.eln.user.dto.UserDto;
import br.com.ucs.eln.user.dto.UserLockDto;
import br.com.ucs.eln.user.exception.UserException;
import br.com.ucs.eln.user.exception.UserExceptionKey;
import br.com.ucs.eln.user.model.User;
import br.com.ucs.eln.user.model.UserLock;
import br.com.ucs.eln.user.repository.UserRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class UserManageBusiness {

    @Inject
    UserRepository repository;
    @Inject
    GroupRepository groupRepository;

    public User getUserById(Long id) throws UserException {
        return repository.findExistingById(id);
    }

    public User updateUser(Long id, UserDto dto) throws UserException, GroupException {
        User user = getUserById(id);

        attemptToUpdateUsername(user, dto.getUsername());
        attemptToUpdatePassword(user, dto.getPassword());
        attemptToUpdateDescription(user, dto.getDescription());
        attemptToUpdateEmail(user, dto.getEmail());
        attemptToUpdateLock(user, dto.getLock());
        attemptToUpdateFullName(user, dto.getFullName());
        attemptToUpdateImage(user, dto.getImage());
        attemptToUpdateGroup(dto, user);

        return user;
    }

    private static void attemptToUpdateUsername(User user, String username) {
        if (!StringUtil.isEmpty(username)) {
            user.setUsername(username);
        }
    }

    private static void attemptToUpdatePassword(User user, String password) {
        if (!StringUtil.isEmpty(password)) {
            user.setPassword(MD5Util.passwordMD5(password));
        }
    }

    private static void attemptToUpdateDescription(User user, String description) {
        if (!StringUtil.isEmpty(description)) {
            user.setDescription(description);
        }
    }

    private void attemptToUpdateEmail(User user, String email) throws UserException {
        if (!StringUtil.isEmpty(email)) {
            validateEmail(user, email);
            user.setEmail(email);
        }
    }

    private void validateEmail(User user, String email) throws UserException {
        if (!user.getEmail().equals(email)) {
            if (repository.existsByEmail(email)) {
                throw new UserException(UserExceptionKey.USER_EMAIL_ALREADY_REGISTERED);
            }
        }
    }

    private void attemptToUpdateLock(User user, UserLockDto lock) {
        if (lock != null) {
            user.setLock(getLock(lock));
        }
    }

    private void attemptToUpdateFullName(User user, String fullName) {
        if (!StringUtil.isEmpty(fullName)) {
            user.setFullName(fullName);
        }
    }

    private void attemptToUpdateImage(User user, byte[] image) {
        if (image == null) return;

        user.setImage(image);
    }

    private void attemptToUpdateGroup(UserDto dto, User user) throws GroupException {
        Long groupId = dto.getGroupId();
        if (groupId == null) return;

        Group group = groupRepository.findExistingById(groupId);
        user.setGroup(group);
    }

    private UserLock getLock(UserLockDto lock) {
        return switch (lock) {
            case LOCKED -> UserLock.LOCKED;
            case UNLOCKED -> UserLock.UNLOCKED;
            case PENDING -> UserLock.PENDING;
        };
    }
}
