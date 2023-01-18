package br.com.ucs.eln.user.ws.mapper;

import br.com.ucs.eln.user.model.User;
import br.com.ucs.eln.user.ws.model.UserProfilePayload;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class UserProfilePayloadMapper {

    public UserProfilePayload map(User user) {
        var entity = new UserProfilePayload();

        entity.setId(user.getId());
        entity.setUsername(user.getUsername());
        entity.setFullName(user.getFullName());
        entity.setEmail(user.getEmail());
        entity.setDescription(user.getDescription());
        entity.setMainImage(user.getImage());

        return entity;
    }

}
