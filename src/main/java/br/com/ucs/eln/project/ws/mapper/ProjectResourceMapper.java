package br.com.ucs.eln.project.ws.mapper;

import br.com.ucs.eln.project.model.Project;
import br.com.ucs.eln.project.ws.response.ProjectGetResponse;
import br.com.ucs.eln.project.ws.response.ProjectListResponse;
import br.com.ucs.eln.project.ws.response.ProjectListResumedResponse;
import br.com.ucs.eln.project.ws.response.ProjectSearchCountResponse;
import br.com.ucs.eln.project.ws.response.ProjectSearchResponse;
import br.com.ucs.eln.project.ws.response.ProjectTotalCountResponse;
import br.com.ucs.eln.user.repository.UserRepository;
import br.com.ucs.eln.ws.response.ApiResponse;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class ProjectResourceMapper {

    @Inject
    ProjectPayloadMapper payloadMapper;
    @Inject
    ProjectResumedPayloadMapper reumedPayloadMapper;
    @Inject
    UserRepository userRepository;

    public ProjectTotalCountResponse mapToTotalProjectsCountResponse(long totalCount) {
        return new ProjectTotalCountResponse(totalCount);
    }

    public ProjectListResponse mapToListProjectsResponse(List<Project> projectList, long userId) {
        var user = userRepository.findById(userId);
        return new ProjectListResponse(payloadMapper.map(projectList, user));
    }

    public ProjectSearchResponse mapToSearchProjectsResponse(List<Project> projectList, long userId) {
        var user = userRepository.findById(userId);
        return new ProjectSearchResponse(payloadMapper.map(projectList, user));
    }

    public ProjectSearchCountResponse mapToSearchProjectsCountResponse(long count) {
        return new ProjectSearchCountResponse(count);
    }

    public ProjectGetResponse mapToProjectGetResponse(Project project) {
        return new ProjectGetResponse(payloadMapper.map(project, null));
    }

    public ApiResponse mapToUserListResumedProjectsResponse(List<Project> projectList) {
        return new ProjectListResumedResponse(reumedPayloadMapper.map(projectList));
    }
}
