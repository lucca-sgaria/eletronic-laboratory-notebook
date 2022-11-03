package br.com.ucs.eln.experiment.ws.flag;

import br.com.ucs.eln.experiment.exception.ExperimentException;

public class ExperimentUpdateError {
    public static String resolve(Exception e) {
        if (e instanceof ExperimentException ex) {
            return ex.getKey().name();
        }
        return "ERROR";
    }
}
