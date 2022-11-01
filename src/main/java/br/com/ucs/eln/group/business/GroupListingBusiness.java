package br.com.ucs.eln.group.business;

import br.com.ucs.eln.group.model.Group;
import br.com.ucs.eln.group.repository.GroupRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class GroupListingBusiness {

    @Inject
    GroupRepository repository;

    public long totalCount() {
        return repository.count();
    }

    public List<Group> listGroups(int page, int pageSize) {
        return repository.list(page, pageSize);
    }

    public List<Group> listGroups() {
        return repository.list();
    }
}
