package br.com.ucs.eln.group.dto;

import br.com.ucs.eln.globals.DateUtil;
import br.com.ucs.eln.group.model.Function;
import br.com.ucs.eln.group.model.Group;

import javax.enterprise.context.RequestScoped;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class GroupDtoMapper {

    public List<GroupDto> map(List<Group> groupList) {
        return groupList
                .stream()
                .map(this::map)
                .toList();
    }

    public GroupDto map(Group group) {
        var entity = new GroupDto();
        entity.setId(group.getId());
        entity.setCreated(DateUtil.formatDate(group.getCreated()));
        entity.setName(group.getName());
        entity.setDescription(group.getDescription());
        entity.setAdmin(group.isAdmin());
        entity.setAllowedFunctions(mapAllowedFunctions(group.getFunctions()));

        return entity;
    }

    private List<String> mapAllowedFunctions(List<Function> functions) {
        return functions.stream()
                .filter(Function::isAllowed)
                .map(Function::getName)
                .collect(Collectors.toList());
    }
}
