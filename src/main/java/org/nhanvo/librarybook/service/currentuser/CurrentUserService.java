package org.nhanvo.librarybook.service.currentuser;

import org.nhanvo.librarybook.domain.CurrentUser;

public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
