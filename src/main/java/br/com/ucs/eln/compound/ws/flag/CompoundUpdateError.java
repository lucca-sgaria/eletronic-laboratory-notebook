package br.com.ucs.eln.compound.ws.flag;

import br.com.ucs.eln.compound.exception.CompoundException;

public class CompoundUpdateError {
    public static String resolve(CompoundException e) {
        return e.getKey().name();
    }
}
