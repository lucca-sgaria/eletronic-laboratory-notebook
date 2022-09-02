package br.com.ucs.eln.ws;

import br.com.ucs.eln.group.exception.GroupException;
import br.com.ucs.eln.user.exception.UserException;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

import javax.ws.rs.core.Response;

public class ExceptionMappers {

    @ServerExceptionMapper
    public RestResponse<String> mapException(GroupException ex) {
        return switch (ex.getKey()) {
            case GROUP_ALREADY_CREATED -> RestResponse.status(Response.Status.BAD_REQUEST, ex.toString());
            case GROUP_NOT_FOUND -> RestResponse.status(Response.Status.NOT_FOUND, ex.toString());
        };
    }

    @ServerExceptionMapper
    public RestResponse<String> mapException(UserException ex) {
        return switch (ex.getKey()) {
            case USER_EMAIL_ALREADY_REGISTERED -> RestResponse.status(Response.Status.BAD_REQUEST, ex.toString());
            case USER_NOT_FOUND -> RestResponse.status(Response.Status.NOT_FOUND, ex.toString());
        };
    }

}
