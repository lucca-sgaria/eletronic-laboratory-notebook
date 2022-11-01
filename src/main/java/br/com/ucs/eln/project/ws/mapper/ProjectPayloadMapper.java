package br.com.ucs.eln.project.ws.mapper;

import br.com.ucs.eln.globals.DateUtil;
import br.com.ucs.eln.project.model.Project;
import br.com.ucs.eln.project.ws.model.ProjectPayload;
import br.com.ucs.eln.user.model.User;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class ProjectPayloadMapper {

    public List<ProjectPayload> map(List<Project> projectList, User user) {
        return projectList
                .stream()
                .map(project -> map(project, user))
                .toList();
    }

    public ProjectPayload map(Project project, User user) {
        var payload = new ProjectPayload();
        payload.setId(project.getId());
        payload.setNumber(project.getNumber());
        payload.setTitle(project.getTitle());
        payload.setCreated(formatCreatedDate(project));
        payload.setDescription(project.getDescription());
        payload.setExperimentsNumber(0);
        payload.setUsersNumber(project.getUsers().size());
        if(user != null) payload.setParticipant(project.getUsers().contains(user));
        payload.setState(project.getState());
        payload.setOnlyProjectUsers(project.isOnlyProjectUsers());

        return payload;
    }

    private static String formatCreatedDate(Project project) {
        return DateUtil.formatDate(project.getCreated());
    }

}
