package br.com.ucs.eln.ws.request;

public class UserLoginRequest extends Request {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
