package br.com.ucs.eln.ws.response;

import org.jboss.resteasy.reactive.RestResponse;

public class ApiErrorResponse {
    private int status;
    private String flag;

    public static ApiErrorResponse badRequest(String flag) {
        return new ApiErrorResponse(RestResponse.StatusCode.NOT_FOUND, flag);
    }

    public static ApiErrorResponse unknown() {
        return new ApiErrorResponse(RestResponse.StatusCode.NOT_FOUND, "UNKNOWN");
    }

    private ApiErrorResponse(int status, String flag) {
        this.status = status;
        this.flag = flag;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
