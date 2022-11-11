package br.com.ucs.eln.project.ws.response;

import br.com.ucs.eln.project.ws.model.ProjectResumedPayload;
import br.com.ucs.eln.ws.response.ApiResponse;

import java.util.List;

public class ProjectListResumedResponse extends ApiResponse {
    private List<ProjectResumedPayload> projectList;

    public ProjectListResumedResponse(List<ProjectResumedPayload> projectList) {
        this.projectList = projectList;
    }

    public List<ProjectResumedPayload> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<ProjectResumedPayload> projectList) {
        this.projectList = projectList;
    }
}
