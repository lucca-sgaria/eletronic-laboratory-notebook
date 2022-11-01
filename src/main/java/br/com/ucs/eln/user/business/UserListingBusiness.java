package br.com.ucs.eln.user.business;

import br.com.ucs.eln.user.model.User;
import br.com.ucs.eln.user.repository.UserRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class UserListingBusiness {

    @Inject
    UserRepository repository;

    public long totalCount() {
        return repository.count();
    }

    public int totalPages(Integer pageSize) {
        return repository.totalPages(pageSize);
    }

    public List<User> listUsers(int page, int pageSize) {
        return repository.list(page, pageSize);
    }
}
