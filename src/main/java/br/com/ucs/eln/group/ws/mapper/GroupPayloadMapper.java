package br.com.ucs.eln.group.ws.mapper;

import br.com.ucs.eln.globals.DateUtil;
import br.com.ucs.eln.group.model.Function;
import br.com.ucs.eln.group.model.Group;
import br.com.ucs.eln.group.ws.model.GroupPayload;

import javax.enterprise.context.RequestScoped;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class GroupPayloadMapper {

    public List<GroupPayload> map(List<Group> groupList) {
        return groupList
                .stream()
                .map(this::map)
                .toList();
    }

    public GroupPayload map(Group group) {
        var payload = new GroupPayload();
        payload.setId(group.getId());
        payload.setName(group.getName());
        payload.setDescription(group.getDescription());
        payload.setAdmin(group.isAdmin());
        payload.setCreated(formatCreatedDate(group));
        payload.setAllowedFunctions(getAllowedFunctions(group));
        payload.setUserNumber(group.getUsers().size());

        return payload;
    }

    private static String formatCreatedDate(Group group) {
        return DateUtil.formatDate(group.getCreated());
    }

    private List<String> getAllowedFunctions(Group group) {
        return group.getFunctions()
                .stream()
                .filter(Function::isAllowed)
                .map(Function::getName)
                .collect(Collectors.toList());
    }

}
