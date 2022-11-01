package br.com.ucs.eln.compound.business;

import br.com.ucs.eln.compound.model.Compound;
import br.com.ucs.eln.compound.repository.CompoundRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class CompoundSearchBusiness {

    @Inject
    CompoundRepository repository;

    public long searchCount(String searchKey) {
        return repository.searchCount(searchKey);
    }

    public List<Compound> searchCompounds(int page, int pageSize, String searchKey) {
        return repository.searchCompounds(searchKey, page, pageSize);
    }
}
