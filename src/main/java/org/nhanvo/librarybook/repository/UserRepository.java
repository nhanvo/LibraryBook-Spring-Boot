package org.nhanvo.librarybook.repository;

import org.nhanvo.librarybook.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * 
 * @author nhanvo
 * User repository class, inheritance from JPA repository
 */
public interface UserRepository extends JpaRepository<User, Long> {
	/**
	 * Find one user by email
	 * @param email Email of user
	 * @return User
	 */
    Optional<User> findOneByEmail(String email);
}
