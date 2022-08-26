package br.com.ucs.eln.user.facade;

import br.com.ucs.eln.user.business.UserRegistrationEmailSender;
import br.com.ucs.eln.user.dto.UserDto;
import br.com.ucs.eln.user.exception.UserException;
import br.com.ucs.eln.user.generator.UserGenerator;
import br.com.ucs.eln.user.model.User;
import br.com.ucs.eln.user.repository.UserRepository;
import br.com.ucs.eln.user.validator.UserRegistrationValidator;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
public class UserFacade {

    @Inject
    UserRepository userRepository;
    @Inject
    UserGenerator userGenerator;
    @Inject
    UserRegistrationEmailSender emailSender;
    @Inject
    UserRegistrationValidator userRegistrationValidator;

    @Transactional
    public User registration(String email) throws UserException {
        userRegistrationValidator.validate(email);
        emailSender.send(email);
        return userGenerator.generatePendingUser(email);
    }

    public List<User> list(int page, int pageSize) {
        return userRepository.list(page, pageSize);
    }

    public int pageCount(int pageSize) {
        return userRepository.pageCount(pageSize);
    }

    public long usersCount() {
        return userRepository.count();
    }

    public List<User> partialSearch(String searchKey, int page, int pageSize) {
        return userRepository.partialSearch(searchKey, page, pageSize);
    }

    public User findById(Long id) throws UserException {
        return userRepository.findExistingById(id);
    }

    @Transactional
    public User update(Long id, UserDto userDto) throws UserException {
        var user = userRepository.findExistingById(id);
        return userRepository.updateUserFields(
                user,
                userDto
        );
    }

    @Transactional
    public void delete(Long id) throws UserException {
        User user = userRepository.findExistingById(id);
        userRepository.delete(user);
    }

    public User findByEmail(String email) throws UserException {
        return userRepository.findExistingByEmail(email);
    }
}
