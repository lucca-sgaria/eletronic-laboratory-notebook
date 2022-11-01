package br.com.ucs.eln.project.ws.flag;

import br.com.ucs.eln.project.exception.ProjectException;

public class ProjectGetError {
    public static String resolve(ProjectException e) {
        return e.getKey().name();
    }
}
