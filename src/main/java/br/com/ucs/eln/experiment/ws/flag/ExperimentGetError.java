package br.com.ucs.eln.experiment.ws.flag;

import br.com.ucs.eln.experiment.exception.ExperimentException;

public class ExperimentGetError {
    public static String resolve(ExperimentException e) {
        return e.getKey().name();
    }
}
