package br.com.ucs.eln.group.ws.mapper;

import br.com.ucs.eln.group.model.Group;
import br.com.ucs.eln.group.ws.response.GroupGetResponse;
import br.com.ucs.eln.group.ws.response.GroupListResponse;
import br.com.ucs.eln.group.ws.response.GroupListResumedResponse;
import br.com.ucs.eln.group.ws.response.GroupSearchCountResponse;
import br.com.ucs.eln.group.ws.response.GroupSearchResponse;
import br.com.ucs.eln.group.ws.response.GroupTotalCountResponse;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class GroupResourceMapper {

    @Inject
    GroupPayloadMapper payloadMapper;
    @Inject
    GroupResumedPayloadMapper resumedPayloadMapper;

    public GroupTotalCountResponse mapToTotalGroupsCountResponse(long totalCount) {
        return new GroupTotalCountResponse(totalCount);
    }

    public GroupListResponse mapToListGroupsResponse(List<Group> groupList) {
        return new GroupListResponse(payloadMapper.map(groupList));
    }

    public GroupSearchResponse mapToSearchGroupsResponse(List<Group> groupList) {
        return new GroupSearchResponse(payloadMapper.map(groupList));
    }

    public GroupSearchCountResponse mapToSearchGroupsCountResponse(long count) {
        return new GroupSearchCountResponse(count);
    }

    public GroupListResumedResponse mapToListGroupsResumedResponse(List<Group> groupList) {
        return new GroupListResumedResponse(resumedPayloadMapper.map(groupList));
    }

    public GroupGetResponse mapToGroupGetResponse(Group group) {
        return new GroupGetResponse(payloadMapper.map(group));
    }
}
