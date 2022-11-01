package br.com.ucs.eln.compound.ws.mapper;

import br.com.ucs.eln.compound.model.Compound;
import br.com.ucs.eln.compound.ws.model.CompoundPayload;
import br.com.ucs.eln.globals.DateUtil;
import br.com.ucs.eln.group.model.Function;
import br.com.ucs.eln.group.model.Group;

import javax.enterprise.context.RequestScoped;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class CompoundPayloadMapper {

    public List<CompoundPayload> map(List<Compound> compoundList) {
        return compoundList
                .stream()
                .map(this::map)
                .toList();
    }

    public CompoundPayload map(Compound compound) {
        var payload = new CompoundPayload();
        payload.setId(compound.getId());
        payload.setName(compound.getName());
        payload.setDescription(compound.getDescription());
        payload.setCreated(formatCreatedDate(compound));
        payload.setMolarMass(compound.getMolarMass());
        payload.setUnitMeasure(compound.getUnitMeasure().getName());

        return payload;
    }

    private static String formatCreatedDate(Compound compound) {
        return DateUtil.formatDate(compound.getCreated());
    }

    private List<String> getAllowedFunctions(Group group) {
        return group.getFunctions()
                .stream()
                .filter(Function::isAllowed)
                .map(Function::getName)
                .collect(Collectors.toList());
    }

}
