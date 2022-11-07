package br.com.ucs.eln.experiment_line.model;

import br.com.ucs.eln.compound.model.Compound;
import br.com.ucs.eln.experiment.model.Experiment;
import br.com.ucs.eln.user.model.User;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "eln_experimentline")
public class ExperimentLine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime created = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private ExperimentLineType type;

    private Double moles;
    private Double amount;

    @ManyToOne(optional = false)
    private Compound substance;

    @ManyToOne(optional = false)
    private Experiment experiment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public ExperimentLineType getType() {
        return type;
    }

    public void setType(ExperimentLineType type) {
        this.type = type;
    }

    public Double getMoles() {
        return moles;
    }

    public void setMoles(Double moles) {
        this.moles = moles;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Compound getSubstance() {
        return substance;
    }

    public void setSubstance(Compound substance) {
        this.substance = substance;
    }

    public Experiment getExperiment() {
        return experiment;
    }

    public void setExperiment(Experiment experiment) {
        this.experiment = experiment;
    }

    @Override
    public String toString() {
        return "ExperimentLine{" +
                "id=" + id +
                ", created=" + created +
                ", type=" + type +
                ", moles=" + moles +
                ", amount=" + amount +
                ", substance=" + substance +
                ", experiment=" + experiment +
                '}';
    }
}
