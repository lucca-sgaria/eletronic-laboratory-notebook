package br.com.ucs.eln.project.ws.mapper;

import br.com.ucs.eln.project.model.Project;
import br.com.ucs.eln.project.ws.model.ProjectResumedPayload;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class ProjectResumedPayloadMapper {

    public List<ProjectResumedPayload> map(List<Project> projectList) {
        return projectList
                .stream()
                .map(this::map)
                .toList();
    }

    public ProjectResumedPayload map(Project project) {
        var payload = new ProjectResumedPayload();
        payload.setId(project.getId());
        payload.setNumber(project.getNumber());

        return payload;
    }
}
