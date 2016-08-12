package org.nhanvo.librarybook.servicecurrent;

import org.nhanvo.librarybook.domain.CurrentUser;
import org.nhanvo.librarybook.domain.User;
import org.nhanvo.librarybook.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author nhanvo
 * Current User detail service class
 *
 */
@Service
public class CurrentUserDetailsService implements UserDetailsService {

	// Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentUserDetailsService.class);
    
    // User service
    private final UserService userService;

    /**
     * Constructor
     * @param userService
     */
    @Autowired
    public CurrentUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    /**
     * Override from parent
     */
    @Override
    public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {
        LOGGER.debug("Authenticating user with email={}", email.replaceFirst("@.*", "@***"));
        User user = userService.getUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email=%s was not found", email)));
        return new CurrentUser(user);
    }

}
