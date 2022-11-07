package br.com.ucs.eln.experiment_line.repository;

import br.com.ucs.eln.experiment_line.model.ExperimentLine;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ExperimentLineRepository implements PanacheRepository<ExperimentLine> {

}
