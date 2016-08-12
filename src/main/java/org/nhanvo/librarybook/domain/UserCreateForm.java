package org.nhanvo.librarybook.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * 
 * @author nhanvo
 * Create new user form class
 */
public class UserCreateForm {
	// Email
    @NotEmpty
    private String email = "";

    // Password
    @NotEmpty
    private String password = "";

    // Password repeat
    @NotEmpty
    private String passwordRepeated = "";

    // Role
    @NotNull
    private Role role = Role.USER;

    // First name
    @NotEmpty
    private String firstname = "";
    
    // Last name
    @NotEmpty
    private String lastname = "";

    //=========================================================================
    // Set and Get functions
    //=========================================================================
    public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepeated() {
        return passwordRepeated;
    }

    public void setPasswordRepeated(String passwordRepeated) {
        this.passwordRepeated = passwordRepeated;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserCreateForm{" +
                "email='" + email.replaceFirst("@.+", "@***") + '\'' +
                ", password=***" + '\'' +
                ", passwordRepeated=***" + '\'' +
                ", role=" + role +
                ", firstname=" + firstname +
                ", lastname=" + lastname +
                '}';
    }
    //=========================================================================

}
