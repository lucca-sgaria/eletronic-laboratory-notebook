package br.com.ucs.eln.group.ws.mapper;

import br.com.ucs.eln.group.model.Group;
import br.com.ucs.eln.group.ws.model.GroupResumedPayload;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class GroupResumedPayloadMapper {

    public List<GroupResumedPayload> map(List<Group> groupList) {
        return groupList
                .stream()
                .map(this::map)
                .toList();
    }

    public GroupResumedPayload map(Group group) {
        return new GroupResumedPayload(group.getId(), group.getName());
    }

}
