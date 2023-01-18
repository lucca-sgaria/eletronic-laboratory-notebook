package br.com.ucs.eln.compound.business;

import br.com.ucs.eln.compound.exception.CompoundException;
import br.com.ucs.eln.compound.exception.CompoundExceptionKey;
import br.com.ucs.eln.compound.model.Compound;
import br.com.ucs.eln.compound.model.UnitMeasure;
import br.com.ucs.eln.compound.repository.CompoundRepository;
import br.com.ucs.eln.compound.repository.UnitMeasureRepository;
import br.com.ucs.eln.compound.ws.request.UnitMeasureAddRequest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class CompoundManageBusiness {

    @Inject
    CompoundRepository repository;
    @Inject
    UnitMeasureRepository unitMeasureRepository;

    public void addCompound(String name,
                            String description,
                            double molarMass,
                            String unitMeasure) throws CompoundException {
        var compound = new Compound();
        defineName(compound, name);
        compound.setDescription(description);
        compound.setMolarMass(molarMass);
        defineUnitMeasure(compound, unitMeasure);

        repository.persist(compound);
    }

    private void defineName(Compound compound, String name) throws CompoundException {
        if (repository.existsByName(name)) {
            throw new CompoundException(CompoundExceptionKey.COMPOUND_ALREADY_EXISTS);
        }
        compound.setName(name);
    }

    private void defineUnitMeasure(Compound compound, String unitMeasureName) {
        var unitMeasure = unitMeasureRepository.findByName(unitMeasureName);
        if (unitMeasure == null) {
            unitMeasure = generateUnitMeasure(unitMeasureName);
        }

        compound.setUnitMeasure(unitMeasure);
    }

    private UnitMeasure generateUnitMeasure(String unitMeasureName) {
        var entity = new UnitMeasure();
        entity.setName(unitMeasureName);

        unitMeasureRepository.persist(entity);
        return entity;
    }

    public Compound getCompoundById(Long id) throws CompoundException {
        return repository.findExistingById(id);
    }

    public void updateCompound(Long id,
                               String name,
                               String description,
                               double molarMass,
                               String unitMeasure) throws CompoundException {
        var compound = getCompoundById(id);

        if (!name.equals(compound.getName())) defineName(compound, name);
        compound.setDescription(description);
        compound.setMolarMass(molarMass);
        defineUnitMeasure(compound, unitMeasure);
    }


    public void addUnitMeasure(UnitMeasureAddRequest request) throws CompoundException {
        confirmNameIsUnique(request.getName());

        var unitMeasure = new UnitMeasure();
        unitMeasure.setName(request.getName());

        unitMeasureRepository.persist(unitMeasure);
    }

    private void confirmNameIsUnique(String name) throws CompoundException {
        if(unitMeasureRepository.existsByName(name)) {
            throw new CompoundException(CompoundExceptionKey.UNIT_MEASURE_ALREADY_EXISTS);
        }
    }
}
