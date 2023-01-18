package br.com.ucs.eln.user.ws.response;

import br.com.ucs.eln.user.ws.model.ProfileProjectPayload;
import br.com.ucs.eln.ws.response.ApiResponse;

import java.util.List;

public class SearchProfileProjectResponse extends ApiResponse {
    private List<ProfileProjectPayload> projectList;

    public SearchProfileProjectResponse(List<ProfileProjectPayload> projectList) {
        this.projectList = projectList;
    }

    public List<ProfileProjectPayload> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<ProfileProjectPayload> projectList) {
        this.projectList = projectList;
    }
}
