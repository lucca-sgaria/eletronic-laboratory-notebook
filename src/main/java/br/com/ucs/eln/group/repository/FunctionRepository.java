package br.com.ucs.eln.group.repository;

import br.com.ucs.eln.group.model.Function;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FunctionRepository implements PanacheRepository<Function> {

}
