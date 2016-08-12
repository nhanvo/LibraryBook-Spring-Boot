package org.nhanvo.librarybook.servicecurrent;

import org.nhanvo.librarybook.domain.CurrentUser;

/**
 * 
 * @author nhanvo
 * Current user service interface
 *
 */
public interface CurrentUserService {
	/**
	 * Can access user
	 * @param currentUser Current user
	 * @param userId Id of user
	 * @return
	 */
    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
