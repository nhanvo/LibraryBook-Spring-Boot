package org.nhanvo.librarybook.service;

import java.util.Collection;
import java.util.Optional;

import org.nhanvo.librarybook.domain.User;
import org.nhanvo.librarybook.domain.UserCreateForm;

/**
 * 
 * @author nhanvo
 * User service interface
 *
 */
public interface UserService {
	/**
	 * Get user by Id
	 * @param id Id of user
	 * @return User founded
	 */
    Optional<User> getUserById(long id);

    /**
     * Get user by email
     * @param email Email of user
     * @return User founded
     */
    Optional<User> getUserByEmail(String email);

    /**
     *  Get all users
     * @return List all users
     */
    Collection<User> getAllUsers();

    /**
     * Create new user
     * @param form User create form
     * @return User created
     */
    User create(UserCreateForm form);

}
