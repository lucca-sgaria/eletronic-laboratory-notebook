package br.com.ucs.eln.compound.business;

import br.com.ucs.eln.compound.model.Compound;
import br.com.ucs.eln.compound.model.UnitMeasure;
import br.com.ucs.eln.compound.repository.CompoundRepository;
import br.com.ucs.eln.compound.repository.UnitMeasureRepository;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class CompoundListingBusiness {

    @Inject
    CompoundRepository repository;
    @Inject
    UnitMeasureRepository unitMeasureRepository;

    public long totalCount() {
        return repository.count();
    }

    public List<Compound> listCompounds(int page, int pageSize) {
        return repository.list(page, pageSize);
    }

    public List<UnitMeasure> listUnitMeasure() {
        return unitMeasureRepository.listAll(Sort.by("id"));
    }
}
