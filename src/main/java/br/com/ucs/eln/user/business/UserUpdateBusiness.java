package br.com.ucs.eln.user.business;

import br.com.ucs.eln.globals.StringUtil;
import br.com.ucs.eln.user.dto.UserDto;
import br.com.ucs.eln.user.dto.UserLockDto;
import br.com.ucs.eln.user.model.User;
import br.com.ucs.eln.user.model.UserLock;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class UserUpdateBusiness {

    public User updateUserFields(User user, UserDto userDto) {
        attemptToUpdateUsername(user, userDto.getUsername());
        attemptToUpdatePassword(user, userDto.getPassword());
        attemptToUpdateDescription(user, userDto.getDescription());
        attemptToUpdateEmail(user, userDto.getEmail());
        attemptToUpdateLock(user, userDto.getLock());
        attemptToUpdateFullName(user, userDto.getFullName());
        attemptToUpdateImage(user, userDto.getImage());

        return user;
    }

    private static void attemptToUpdateUsername(User user, String username) {
        if (StringUtil.isEmpty(username)) {
            user.setUsername(username);
        }
    }

    private static void attemptToUpdatePassword(User user, String password) {
        if (!StringUtil.isEmpty(password)){
            user.setPassword(password);
        }
    }

    private static void attemptToUpdateDescription(User user, String description) {
        if (!StringUtil.isEmpty(description)) {
            user.setDescription(description);
        }
    }

    private void attemptToUpdateEmail(User user, String email) {
        if (!StringUtil.isEmpty(email)) {
            user.setEmail(email);
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

    private UserLock getLock(UserLockDto lock) {
        return switch (lock) {
            case LOCKED -> UserLock.LOCKED;
            case UNLOCKED -> UserLock.UNLOCKED;
            case PENDING -> UserLock.PENDING;
        };
    }
}
