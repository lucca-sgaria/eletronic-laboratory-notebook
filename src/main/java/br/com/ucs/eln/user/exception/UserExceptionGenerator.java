package br.com.ucs.eln.user.exception;

public class UserExceptionGenerator {

    public static UserException USER_NOT_FOUND() {
        return new UserException(UserExceptionKey.USER_NOT_FOUND);
    }
}
