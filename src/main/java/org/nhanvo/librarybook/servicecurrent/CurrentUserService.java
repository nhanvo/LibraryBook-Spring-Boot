package org.nhanvo.librarybook.servicecurrent;

import org.nhanvo.librarybook.domain.CurrentUser;

public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
