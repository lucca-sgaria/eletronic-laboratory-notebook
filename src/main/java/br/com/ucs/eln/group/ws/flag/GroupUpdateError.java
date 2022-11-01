package br.com.ucs.eln.group.ws.flag;

import br.com.ucs.eln.group.exception.GroupException;

public class GroupUpdateError {
    public static String resolve(GroupException e) {
        return e.getKey().name();
    }
}
