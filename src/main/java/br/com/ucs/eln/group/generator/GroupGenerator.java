package br.com.ucs.eln.group.generator;

import br.com.ucs.eln.group.dto.GroupDto;
import br.com.ucs.eln.group.exception.GroupException;
import br.com.ucs.eln.group.model.Group;
import br.com.ucs.eln.group.repository.GroupRepository;
import br.com.ucs.eln.group.validator.GroupGenerationValidator;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class GroupGenerator {

    @Inject
    GroupRepository repository;
    @Inject
    GroupGenerationValidator generationValidator;

    public Group generate(GroupDto groupDto) throws GroupException {
        generationValidator.validate(groupDto.getName());

        Group group = new Group();
        group.setName(groupDto.getName());
        group.setDescription(groupDto.getDescription());
        group.setAdmin(groupDto.isAdmin());
        repository.persist(group);

        return group;
    }

}
