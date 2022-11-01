package br.com.ucs.eln.group.ws.response;

import br.com.ucs.eln.group.ws.model.GroupPayload;
import br.com.ucs.eln.ws.response.ApiResponse;

import java.util.List;

public class GroupListResponse extends ApiResponse {
    private List<GroupPayload> groupList;

    public GroupListResponse(List<GroupPayload> groupList) {
        this.groupList = groupList;
    }

    public List<GroupPayload> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<GroupPayload> groupList) {
        this.groupList = groupList;
    }
}
