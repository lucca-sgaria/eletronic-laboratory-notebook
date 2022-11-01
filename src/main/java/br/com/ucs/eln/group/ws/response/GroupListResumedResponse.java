package br.com.ucs.eln.group.ws.response;

import br.com.ucs.eln.group.ws.model.GroupResumedPayload;
import br.com.ucs.eln.ws.response.ApiResponse;

import java.util.List;

public class GroupListResumedResponse extends ApiResponse {
    private List<GroupResumedPayload> groupList;

    public GroupListResumedResponse(List<GroupResumedPayload> groupList) {
        this.groupList = groupList;
    }

    public List<GroupResumedPayload> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<GroupResumedPayload> groupList) {
        this.groupList = groupList;
    }
}
