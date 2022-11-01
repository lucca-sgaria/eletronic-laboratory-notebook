package br.com.ucs.eln.group.business;

import br.com.ucs.eln.group.model.Group;
import br.com.ucs.eln.group.repository.GroupRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class GroupSearchBusiness {

    @Inject
    GroupRepository repository;

    public long searchCount(String searchKey) {
        return repository.searchCount(searchKey);
    }

    public List<Group> searchGroup(int page, int pageSize, String searchKey) {
        return repository.searchGroups(searchKey, page, pageSize);
    }
}
