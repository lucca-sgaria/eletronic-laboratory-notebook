package br.com.ucs.eln.ws.response;

import org.jboss.resteasy.reactive.RestResponse;

import javax.ws.rs.core.Response;

public class ApiResponseBuilder {

    public static Response ok(ApiResponse apiResponse) {
        return RestResponse.ok(ResponseWrapper.success(apiResponse)).toResponse();
    }

    public static Response ok() {
        return RestResponse.ok(ResponseWrapper.success()).toResponse();
    }

    public static Response error(String errorFlag) {
        return RestResponse.ok(ResponseWrapper.error(errorFlag)).toResponse();
    }

    public static Response error(ApiErrorResponse errorResponse) {
        RestResponse.Status status = RestResponse.Status.fromStatusCode(errorResponse.getStatus());
        return RestResponse.status(status, ResponseWrapper.error(errorResponse.getFlag())).toResponse();
    }

}
