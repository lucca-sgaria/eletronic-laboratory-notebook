package br.com.ucs.eln.compound.repository;

import br.com.ucs.eln.compound.exception.CompoundException;
import br.com.ucs.eln.compound.exception.CompoundExceptionKey;
import br.com.ucs.eln.compound.model.Compound;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CompoundRepository implements PanacheRepository<Compound> {

    public List<Compound> list(int page, int pageSize) {
        return findAll(Sort.by("id"))
                .page(Page.of(page, pageSize))
                .list();
    }

    public List<Compound> searchCompounds(String searchKey, int page, int pageSize) {
        String query = "lower(name) LIKE ?1 " +
                " OR lower(description) LIKE ?1 ";

        return find(query, Sort.by("id"), "%" + searchKey.toLowerCase() + "%")
                .page(Page.of(page, pageSize))
                .list();
    }

    public long searchCount(String searchKey) {
        String query = "lower(name) LIKE ?1 " +
                " OR lower(description) LIKE ?1 ";

        return find(query, "%" + searchKey.toLowerCase() + "%")
                .count();
    }

    public boolean existsByName(String name) {
        return find("name = ?1", name)
                .firstResultOptional()
                .isPresent();
    }

    public Compound findExistingById(Long id) throws CompoundException {
        var compound = findById(id);
        if (compound == null) {
            throw new CompoundException(CompoundExceptionKey.COMPOUND_NOT_FOUND);
        }
        return compound;
    }
}
