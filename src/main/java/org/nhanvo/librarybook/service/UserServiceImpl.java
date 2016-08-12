package org.nhanvo.librarybook.service;

import org.nhanvo.librarybook.domain.User;
import org.nhanvo.librarybook.domain.UserCreateForm;
import org.nhanvo.librarybook.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 * 
 * @author nhanvo
 * User service implement class
 *
 */
@Service
public class UserServiceImpl implements UserService {

	// Define logger
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    
    // User Repository
    private final UserRepository userRepository;

    /**
     * Constructor
     * @param userRepository User repository
     */
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Override from parent
     */
    @Override
    public Optional<User> getUserById(long id) {
        LOGGER.debug("Getting user={}", id);
        return Optional.ofNullable(userRepository.findOne(id));
    }

    /**
     * Override from parent
     */
    @Override
    public Optional<User> getUserByEmail(String email) {
        LOGGER.debug("Getting user by email={}", email.replaceFirst("@.*", "@***"));
        return userRepository.findOneByEmail(email);
    }

    /**
     * Override from parent
     */
    @Override
    public Collection<User> getAllUsers() {
        LOGGER.debug("Getting all users");
        return userRepository.findAll(new Sort("email"));
    }

    /**
     * Override from parent
     */
    @Override
    public User create(UserCreateForm form) {
        User user = new User();
        user.setEmail(form.getEmail());
        user.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
        user.setRole(form.getRole());
        user.setFirstname(form.getFirstname());
        user.setLastname(form.getLastname());     
        LOGGER.debug(user.getPasswordHash());
        return userRepository.save(user);
    }

}
