package br.com.ucs.eln.group.dto;

import br.com.ucs.eln.group.model.Function;
import br.com.ucs.eln.group.model.Group;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class FunctionDtoMapper {

    public List<FunctionDto> map(List<Function> functionList) {
        return functionList
                .stream()
                .map(this::map)
                .toList();
    }

    public FunctionDto map(Function entity) {
        var dto = new FunctionDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setAllowed(entity.isAllowed());

        return dto;
    }


}
