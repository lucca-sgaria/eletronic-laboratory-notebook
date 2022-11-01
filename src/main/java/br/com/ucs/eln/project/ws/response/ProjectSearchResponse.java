package br.com.ucs.eln.project.ws.response;

import br.com.ucs.eln.project.ws.model.ProjectPayload;
import br.com.ucs.eln.ws.response.ApiResponse;

import java.util.List;

public class ProjectSearchResponse extends ApiResponse {
    private List<ProjectPayload> projectList;

    public ProjectSearchResponse(List<ProjectPayload> projectList) {
        this.projectList = projectList;
    }

    public List<ProjectPayload> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<ProjectPayload> projectList) {
        this.projectList = projectList;
    }
}
