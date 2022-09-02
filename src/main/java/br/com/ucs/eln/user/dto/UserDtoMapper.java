package br.com.ucs.eln.user.dto;

import br.com.ucs.eln.user.model.User;
import br.com.ucs.eln.user.model.UserLock;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class UserDtoMapper {

    public List<UserDto> map(List<User> userList) {
        return userList
                .stream()
                .map(this::map)
                .toList();
    }

    public UserDto map(User user) {
        var entity = new UserDto();
        entity.setId(user.getId());
        entity.setFullName(user.getFullName());
        entity.setLock(mapLock(user.getLock()));
        entity.setEmail(user.getEmail());
        entity.setCreated(user.getCreated());
        entity.setUsername(user.getUsername());
        entity.setDescription(user.getDescription());
        entity.setImage(user.getImage());
        entity.setGroupId(user.getGroup().getId());

        return entity;
    }

    private UserLockDto mapLock(UserLock lock) {
        return switch (lock) {
            case LOCKED -> UserLockDto.LOCKED;
            case UNLOCKED -> UserLockDto.UNLOCKED;
            case PENDING -> UserLockDto.PENDING;
        };
    }
}
