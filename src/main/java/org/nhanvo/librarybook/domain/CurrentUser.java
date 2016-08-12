package org.nhanvo.librarybook.domain;

import org.springframework.security.core.authority.AuthorityUtils;
/**
 * Current user class
 * @author nhanvo
 *
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {
	// User
    private User user;

    /**
     * Constructor
     * @param user User object
     */
    public CurrentUser(User user) {
        super(user.getEmail(), user.getPasswordHash(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    /**
     * Get user
     * @return User object
     */
    public User getUser() {
        return user;
    }

    /** 
     * Get Id
     * @return User id
     */
    public Long getId() {
        return user.getId();
    }

    /**
     * Get role
     * @return User role
     */
    public Role getRole() {
        return user.getRole();
    }

    /**
     * Override User information to string
     */
    @Override
    public String toString() {
        return "CurrentUser{" +
                "user=" + user +
                "} " + super.toString();
    }
}
