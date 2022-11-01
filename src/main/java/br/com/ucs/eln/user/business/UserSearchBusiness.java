package br.com.ucs.eln.user.business;

import br.com.ucs.eln.user.model.User;
import br.com.ucs.eln.user.repository.UserRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class UserSearchBusiness {

    @Inject
    UserRepository repository;

    public long searchCount(String searchKey) {
        return repository.searchCount(searchKey);
    }

    public List<User> searchUsers(int page, int pageSize, String searchKey) {
        return repository.searchUsers(searchKey, page, pageSize);
    }
}
