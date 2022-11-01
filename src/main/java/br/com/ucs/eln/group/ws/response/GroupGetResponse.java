package br.com.ucs.eln.group.ws.response;

import br.com.ucs.eln.group.ws.model.GroupPayload;
import br.com.ucs.eln.ws.response.ApiResponse;

public class GroupGetResponse extends ApiResponse {
    private GroupPayload group;

    public GroupGetResponse(GroupPayload group) {
        this.group = group;
    }

    public GroupPayload getGroup() {
        return group;
    }

    public void setGroup(GroupPayload group) {
        this.group = group;
    }
}
