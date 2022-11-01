package br.com.ucs.eln.group.business;

import br.com.ucs.eln.group.exception.GroupException;
import br.com.ucs.eln.group.exception.GroupExceptionKey;
import br.com.ucs.eln.group.model.Function;
import br.com.ucs.eln.group.model.Group;
import br.com.ucs.eln.group.repository.FunctionRepository;
import br.com.ucs.eln.group.repository.GroupRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class GroupManageBusiness {

    @Inject
    GroupRepository repository;
    @Inject
    FunctionRepository functionRepository;

    public void addGroup(String name,
                         String description,
                         List<String> allowedFunctions,
                         boolean admin) throws GroupException {
        var group = new Group();
        updateName(group, name);
        group.setDescription(description);
        group.setAdmin(admin);

        repository.persist(group);

        persistAllowedFunctions(group, allowedFunctions);
    }

    private void persistAllowedFunctions(Group group, List<String> allowedFunctions) {
        for (String functionName : allowedFunctions) {
            var function = new Function();
            function.setAllowed(true);
            function.setName(functionName);
            function.setGroup(group);

            functionRepository.persist(function);
        }
    }

    public Group getGroupById(Long id) throws GroupException {
        return repository.findExistingById(id);
    }

    public void updateGroup(Long id,
                            String name,
                            String description,
                            List<String> allowedFunctions,
                            boolean admin) throws GroupException {
        var group = getGroupById(id);
        if (!name.equals(group.getName())) updateName(group, name);
        group.setDescription(description);
        group.setAdmin(admin);

        deleteFunctions(group);
        persistAllowedFunctions(group, allowedFunctions);
    }

    private void updateName(Group group, String name) throws GroupException {
        if (repository.existsByName(name)) {
            throw new GroupException(GroupExceptionKey.GROUP_ALREADY_EXISTS);
        }
        group.setName(name);
    }

    private void deleteFunctions(Group group) {
        group.getFunctions().forEach(function -> functionRepository.delete(function));
    }
}
