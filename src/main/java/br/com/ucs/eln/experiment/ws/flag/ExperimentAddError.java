package br.com.ucs.eln.experiment.ws.flag;

import br.com.ucs.eln.experiment.exception.ExperimentException;
import br.com.ucs.eln.project.exception.ProjectException;
import br.com.ucs.eln.user.exception.UserException;

public class ExperimentAddError {
    public static String resolve(Exception e) {
        if (e instanceof ProjectException ex) {
            return ex.getKey().name();
        } else if (e instanceof UserException ex) {
            return ex.getKey().name();
        } else if (e instanceof ExperimentException ex) {
            return ex.getKey().name();
        }
        return "ERROR";
    }
}
