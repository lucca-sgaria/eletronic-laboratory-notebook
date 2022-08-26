package br.com.ucs.eln.group.dto;

import br.com.ucs.eln.group.model.Group;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class GroupDtoMapper {

    @Inject
    FunctionDtoMapper functionDtoMapper;

    public List<GroupDto> map(List<Group> groupList) {
        return groupList
                .stream()
                .map(this::map)
                .toList();
    }

    public GroupDto map(Group group) {
        var entity = new GroupDto();
        entity.setId(group.getId());
        entity.setCreated(group.getCreated());
        entity.setName(group.getName());
        entity.setDescription(group.getDescription());
        entity.setAdmin(group.isAdmin());
        entity.setFunctions(functionDtoMapper.map(group.getFunctions()));

        return entity;
    }


}
