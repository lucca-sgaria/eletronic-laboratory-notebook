package br.com.ucs.eln.attachment.ws.flag;

import br.com.ucs.eln.experiment.exception.ExperimentException;
import br.com.ucs.eln.user.exception.UserException;

public class AttachmentAddError {
    public static String resolve(Exception e) {
        if (e instanceof UserException ex) {
            return ex.getKey().name();
        } else if (e instanceof ExperimentException ex) {
            return ex.getKey().name();
        }
        return "ERROR";
    }
}
