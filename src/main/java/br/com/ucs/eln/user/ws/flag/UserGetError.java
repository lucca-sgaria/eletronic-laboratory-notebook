package br.com.ucs.eln.user.ws.flag;

import br.com.ucs.eln.user.exception.UserException;

public class UserGetError {
    public static String resolve(Exception e) {
        if (e instanceof UserException userEx) {
            return switch (userEx.getKey()) {
                case USER_NOT_FOUND -> userEx.getKey().name();
                default -> "UNKNOWN";
            };
        }
        return "UNKNOWN";
    }
}
