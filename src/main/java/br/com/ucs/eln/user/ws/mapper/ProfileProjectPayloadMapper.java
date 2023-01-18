package br.com.ucs.eln.user.ws.mapper;

import br.com.ucs.eln.project.model.Project;
import br.com.ucs.eln.user.ws.model.ProfileProjectPayload;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class ProfileProjectPayloadMapper {

    public List<ProfileProjectPayload> map(List<Project> list) {
        return list
                .stream()
                .map(this::map)
                .toList();
    }

    public ProfileProjectPayload map(Project project) {
        var entity = new ProfileProjectPayload();

        entity.setId(project.getId());
        entity.setTitle(project.getTitle());
        return entity;
    }

}
