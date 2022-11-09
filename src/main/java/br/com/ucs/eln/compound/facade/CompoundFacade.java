package br.com.ucs.eln.compound.facade;

import br.com.ucs.eln.compound.business.CompoundListingBusiness;
import br.com.ucs.eln.compound.business.CompoundManageBusiness;
import br.com.ucs.eln.compound.business.CompoundSearchBusiness;
import br.com.ucs.eln.compound.exception.CompoundException;
import br.com.ucs.eln.compound.model.Compound;
import br.com.ucs.eln.compound.model.UnitMeasure;
import br.com.ucs.eln.compound.ws.request.UnitMeasureAddRequest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
public class CompoundFacade {

    @Inject
    CompoundListingBusiness listingBusiness;
    @Inject
    CompoundSearchBusiness searchBusiness;
    @Inject
    CompoundManageBusiness manageBusiness;

    public long totalCompoundCount() {
        return listingBusiness.totalCount();
    }

    public List<Compound> listCompounds(int page, int pageSize) {
        return listingBusiness.listCompounds(page, pageSize);
    }

    public List<Compound> searchCompounds(int page, int pageSize, String searchKey) {
        return searchBusiness.searchCompounds(page, pageSize, searchKey);
    }

    public long searchCompoundsCount(String searchKey) {
        return searchBusiness.searchCount(searchKey);
    }

    @Transactional
    public void addCompound(String name,
                            String description,
                            double molarMass,
                            String unitMeasure) throws CompoundException {
        manageBusiness.addCompound(name, description, molarMass, unitMeasure);
    }

    public Compound getCompound(Long id) throws CompoundException {
        return manageBusiness.getCompoundById(id);
    }

    @Transactional
    public void updateCompound(Long id,
                               String name,
                               String description,
                               double molarMass,
                               String unitMeasure) throws CompoundException {
        manageBusiness.updateCompound(id, name, description, molarMass, unitMeasure);
    }

    public List<UnitMeasure> listUnitMeasure() {
        return listingBusiness.listUnitMeasure();
    }

    @Transactional
    public void addUnitMeasure(UnitMeasureAddRequest request) throws CompoundException {
        manageBusiness.addUnitMeasure(request);
    }
}
