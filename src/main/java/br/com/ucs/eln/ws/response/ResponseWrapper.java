package br.com.ucs.eln.ws.response;


import java.io.Serializable;

public class ResponseWrapper<D> implements Serializable {
    private boolean done;
    private String flag;
    private D data;

    private ResponseWrapper(boolean done, String flag, D data) {
        this.done = done;
        this.flag = flag;
        this.data = data;
    }

    public static <D> ResponseWrapper<D> success() {
        return success(null);
    }

    public static <D> ResponseWrapper<D> success(D data) {
        return new ResponseWrapper<>(true, null, data);
    }

    public static <D> ResponseWrapper<D> error(String flag) {
        return error(flag, null);
    }

    public static <D> ResponseWrapper<D> error(String flag, D data) {
        return new ResponseWrapper<>(false, flag, data);
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }
}



