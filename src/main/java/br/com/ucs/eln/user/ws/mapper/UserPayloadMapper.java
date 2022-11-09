package br.com.ucs.eln.user.ws.mapper;

import br.com.ucs.eln.user.model.User;
import br.com.ucs.eln.user.ws.model.UserPayload;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class UserPayloadMapper {

    public List<UserPayload> map(List<User> userList) {
        return userList
                .stream()
                .map(this::map)
                .toList();
    }

    public UserPayload map(User user) {
        var entity = new UserPayload();

        entity.setId(user.getId());
        entity.setUsername(user.getUsername());
        entity.setFullName(user.getFullName());
        entity.setLock(user.getLock().name());
        entity.setEmail(user.getEmail());
        entity.setDescription(user.getDescription());
        entity.setMainImage(user.getImage());

        var group = user.getGroup();
        entity.setGroupId(group.getId());
        entity.setGroupName(group.getName());

        return entity;
    }

}
