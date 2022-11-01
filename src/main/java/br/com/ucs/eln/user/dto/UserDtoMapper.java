package br.com.ucs.eln.user.dto;

import br.com.ucs.eln.user.model.User;
import br.com.ucs.eln.user.model.UserLock;
import br.com.ucs.eln.user.ws.model.UserPayload;

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
        var dto = new UserDto();
        dto.setId(user.getId());
        dto.setFullName(user.getFullName());
        dto.setLock(mapLock(user.getLock()));
        dto.setEmail(user.getEmail());
        dto.setCreated(user.getCreated());
        dto.setUsername(user.getUsername());
        dto.setDescription(user.getDescription());
        dto.setImage(user.getImage());
        dto.setGroupId(user.getGroup().getId());

        return dto;
    }

    public UserDto map(UserPayload user) {
        var dto = new UserDto();
        dto.setId(user.getId());
        dto.setFullName(user.getFullName());
        dto.setLock(mapLock(user.getLock()));
        dto.setEmail(user.getEmail());
        dto.setUsername(user.getUsername());
        dto.setDescription(user.getDescription());
        //dto.setImage(user.getImage());
        dto.setGroupId(user.getGroupId());
        dto.setPassword(user.getPassword());

        return dto;
    }

    private UserLockDto mapLock(String lock) {
        return switch (lock) {
            case "LOCKED" -> UserLockDto.LOCKED;
            case "UNLOCKED" -> UserLockDto.UNLOCKED;
            case "PENDING" -> UserLockDto.PENDING;
            default -> null;
        };
    }

    private UserLockDto mapLock(UserLock lock) {
        return switch (lock) {
            case LOCKED -> UserLockDto.LOCKED;
            case UNLOCKED -> UserLockDto.UNLOCKED;
            case PENDING -> UserLockDto.PENDING;
        };
    }
}
