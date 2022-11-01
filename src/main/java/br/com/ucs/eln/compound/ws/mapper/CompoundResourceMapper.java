package br.com.ucs.eln.compound.ws.mapper;

import br.com.ucs.eln.compound.model.Compound;
import br.com.ucs.eln.compound.model.UnitMeasure;
import br.com.ucs.eln.compound.ws.model.UnitMeasurePayload;
import br.com.ucs.eln.compound.ws.response.CompoundGetResponse;
import br.com.ucs.eln.compound.ws.response.CompoundListResponse;
import br.com.ucs.eln.compound.ws.response.CompoundSearchCountResponse;
import br.com.ucs.eln.compound.ws.response.CompoundSearchResponse;
import br.com.ucs.eln.compound.ws.response.CompoundTotalCountResponse;
import br.com.ucs.eln.compound.ws.response.UnitMeasureListResponse;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class CompoundResourceMapper {

    @Inject
    CompoundPayloadMapper payloadMapper;

    public CompoundTotalCountResponse mapToTotalCompoundsCountResponse(long totalCount) {
        return new CompoundTotalCountResponse(totalCount);
    }

    public CompoundListResponse mapToListCompoundsResponse(List<Compound> groupList) {
        return new CompoundListResponse(payloadMapper.map(groupList));
    }

    public CompoundSearchResponse mapToSearchCompoundsResponse(List<Compound> groupList) {
        return new CompoundSearchResponse(payloadMapper.map(groupList));
    }

    public CompoundSearchCountResponse mapToSearchCompoundsCountResponse(long count) {
        return new CompoundSearchCountResponse(count);
    }

    public CompoundGetResponse mapToCompoundGetResponse(Compound compound) {
        return new CompoundGetResponse(payloadMapper.map(compound));
    }

    public UnitMeasureListResponse mapToListUnitMeasureResponse(List<UnitMeasure> list) {
        return new UnitMeasureListResponse(mapToUnitMeasureList(list));
    }

    private static List<UnitMeasurePayload> mapToUnitMeasureList(List<UnitMeasure> list) {
        return list
                .stream()
                .map(UnitMeasurePayload::new)
                .collect(Collectors.toList());
    }
}
