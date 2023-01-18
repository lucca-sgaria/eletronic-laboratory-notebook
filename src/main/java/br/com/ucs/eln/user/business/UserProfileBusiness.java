package br.com.ucs.eln.user.business;

import br.com.ucs.eln.globals.StringUtil;
import br.com.ucs.eln.user.exception.UserException;
import br.com.ucs.eln.user.exception.UserExceptionKey;
import br.com.ucs.eln.user.model.User;
import br.com.ucs.eln.user.repository.UserRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class UserProfileBusiness {

    @Inject
    UserRepository repository;

    public User searchUser(String searchKey, Long userId) throws UserException {
        if (!StringUtil.isEmpty(searchKey)) {
            User user = repository.searchExactUser(searchKey);
            if(user == null) throw new UserException(UserExceptionKey.USER_NOT_FOUND);

            return user;
        }
        return repository.findExistingById(userId);
    }

}
