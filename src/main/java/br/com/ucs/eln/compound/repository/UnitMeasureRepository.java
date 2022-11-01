package br.com.ucs.eln.compound.repository;

import br.com.ucs.eln.compound.model.UnitMeasure;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UnitMeasureRepository implements PanacheRepository<UnitMeasure> {

    public boolean existsByName(String name) {
        return find("name = ?1", name)
                .firstResultOptional()
                .isPresent();
    }

    public UnitMeasure findByName(String name) {
        return find("name = ?1", name)
                .firstResultOptional()
                .orElse(null);
    }

}
