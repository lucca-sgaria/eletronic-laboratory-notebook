package br.com.ucs.eln.project.ws.flag;

import br.com.ucs.eln.project.exception.ProjectException;

public class ProjectUpdateError {
    public static String resolve(ProjectException e) {
        return e.getKey().name();
    }
}
