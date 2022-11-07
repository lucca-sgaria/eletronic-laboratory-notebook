package br.com.ucs.eln.experiment_line.ws.flag;

import br.com.ucs.eln.compound.exception.CompoundException;
import br.com.ucs.eln.experiment.exception.ExperimentException;

public class ExperimentLineAddError {
    public static String resolve(Exception e) {
        if (e instanceof CompoundException ex) {
            return ex.getKey().name();
        } else if (e instanceof ExperimentException ex) {
            return ex.getKey().name();
        }
        return "ERROR";
    }
}
