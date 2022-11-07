package br.com.ucs.eln.experiment_line.ws.request;

import br.com.ucs.eln.ws.request.Request;

public class ExperimentLineAddRequest extends Request {
    private long experimentId;
    private long compoundId;
    private double amount;
    private double moles;
    private String type;

    public long getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(long experimentId) {
        this.experimentId = experimentId;
    }

    public long getCompoundId() {
        return compoundId;
    }

    public void setCompoundId(long compoundId) {
        this.compoundId = compoundId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getMoles() {
        return moles;
    }

    public void setMoles(double moles) {
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
        return "ExperimentLineAddRequest{" +
                "experimentId=" + experimentId +
                ", compoundId=" + compoundId +
                ", amount=" + amount +
                ", moles=" + moles +
                ", type='" + type + '\'' +
                '}';
    }
}
