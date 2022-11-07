package br.com.ucs.eln.experiment_line.ws.request;

import br.com.ucs.eln.ws.request.Request;

public class ExperimentLineUpdateRequest extends Request {
    private Double amount;
    private Double moles;
    private String type;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getMoles() {
        return moles;
    }

    public void setMoles(Double moles) {
        this.moles = moles;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ExperimentLineUpdateRequest{" +
                "amount=" + amount +
                ", moles=" + moles +
                ", type='" + type + '\'' +
                '}';
    }
}
