package br.com.ucs.eln.project.ws.response;

import br.com.ucs.eln.project.ws.model.ProjectPayload;
import br.com.ucs.eln.ws.response.ApiResponse;

public class ProjectGetResponse extends ApiResponse {
    private ProjectPayload project;

    public ProjectGetResponse(ProjectPayload project) {
        this.project = project;
    }

    public ProjectPayload getProject() {
        return project;
    }

    public void setProject(ProjectPayload project) {
        this.project = project;
    }
}
