package org.nhanvo.librarybook.service.user;

import java.util.Collection;
import java.util.Optional;

import org.nhanvo.librarybook.domain.User;
import org.nhanvo.librarybook.domain.UserCreateForm;

public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);

}
