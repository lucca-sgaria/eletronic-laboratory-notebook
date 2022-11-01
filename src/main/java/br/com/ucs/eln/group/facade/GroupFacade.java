package br.com.ucs.eln.group.facade;

import br.com.ucs.eln.group.business.GroupListingBusiness;
import br.com.ucs.eln.group.business.GroupManageBusiness;
import br.com.ucs.eln.group.business.GroupSearchBusiness;
import br.com.ucs.eln.group.dto.GroupDtoMapper;
import br.com.ucs.eln.group.exception.GroupException;
import br.com.ucs.eln.group.model.Group;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
public class GroupFacade {

    @Inject
    GroupDtoMapper dtoMapper;

    @Inject
    GroupListingBusiness listingBusiness;
    @Inject
    GroupSearchBusiness searchBusiness;
    @Inject
    GroupManageBusiness manageBusiness;

    public long totalUsersCount() {
        return listingBusiness.totalCount();
    }

    public List<Group> listGroups(int page, int pageSize) {
        return listingBusiness.listGroups(page, pageSize);
    }

    public List<Group> listGroups() {
        return listingBusiness.listGroups();
    }

    public List<Group> searchGroups(int page, int pageSize, String searchKey) {
        return searchBusiness.searchGroup(page, pageSize, searchKey);
    }

    public long searchUsersCount(String searchKey) {
        return searchBusiness.searchCount(searchKey);
    }

    @Transactional
    public void addGroup(String name,
                         String description,
                         List<String> allowedFunctions,
                         boolean admin) throws GroupException {
        manageBusiness.addGroup(name, description, allowedFunctions, admin);
    }

    public Group getGroup(Long id) throws GroupException {
        return manageBusiness.getGroupById(id);
    }

    @Transactional
    public void updateGroup(Long id,
                            String name,
                            String description,
                            List<String> allowedFunctions,
                            boolean admin) throws GroupException {
        manageBusiness.updateGroup(id, name, description, allowedFunctions, admin);
    }
}
