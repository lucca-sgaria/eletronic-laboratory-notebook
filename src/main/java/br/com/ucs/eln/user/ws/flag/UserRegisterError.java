package br.com.ucs.eln.user.ws.flag;

import br.com.ucs.eln.group.exception.GroupException;
import br.com.ucs.eln.user.exception.UserException;

public class UserRegisterError {
    public static String resolve(Exception e) {
        if (e instanceof UserException ex) {
            return ex.getKey().name();
        } else if (e instanceof GroupException ex) {
            return ex.getKey().name();
        }
        return "UNKNOWN";
    }
}
