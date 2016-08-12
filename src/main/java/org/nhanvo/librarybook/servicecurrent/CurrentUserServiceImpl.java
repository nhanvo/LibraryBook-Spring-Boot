package org.nhanvo.librarybook.servicecurrent;

import org.nhanvo.librarybook.domain.CurrentUser;
import org.nhanvo.librarybook.domain.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Current user service implement class
 * @author nhanvo
 *
 */
@Service
public class CurrentUserServiceImpl implements CurrentUserService {
	// Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentUserDetailsService.class);

    /**
     * Override from parent
     */
    @Override
    public boolean canAccessUser(CurrentUser currentUser, Long userId) {
        LOGGER.debug("Checking if user={} has access to user={}", currentUser, userId);
        return currentUser != null
                && (currentUser.getRole() == Role.ADMIN || currentUser.getId().equals(userId));
    }

}
