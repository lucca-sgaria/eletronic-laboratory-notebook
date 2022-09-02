package br.com.ucs.eln.group.validator;

import br.com.ucs.eln.group.exception.GroupException;
import br.com.ucs.eln.group.exception.GroupExceptionKey;
import br.com.ucs.eln.group.repository.GroupRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class GroupGenerationValidator {

    @Inject
    GroupRepository groupRepository;

    public void validate(String name) throws GroupException {
        requireNameIsNotCreated(name);
    }

    private void requireNameIsNotCreated(String name) throws GroupException {
        if(groupRepository.existsByName(name)) {
            throw new GroupException(GroupExceptionKey.GROUP_ALREADY_CREATED);
        }
    }
}
