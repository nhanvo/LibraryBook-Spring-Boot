package org.nhanvo.librarybook.domain;

import javax.persistence.*;

/**
 * 
 * @author nhanvo
 * User POJO class, mapping data to object from database by Hibernate
 */
@Entity
@Table(name = "user")
public class User {

	// User Id, auto generate
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    // Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    // Password, will be hash code 
    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    // Role
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    // First name
    @Column(name = "firstname", nullable = false)
    private String firstname;
    
    // Last name
    @Column(name = "lastname", nullable = false)
    private String lastname;

    //=========================================================================
  	// Get and Set function
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

	public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email.replaceFirst("@.*", "@***") +
                ", passwordHash='" + passwordHash.substring(0, 10) +
                ", role=" + role +
                ", firstname=" + firstname +
                ", lastname=" + lastname +
                '}';
    }
    //=========================================================================
}
