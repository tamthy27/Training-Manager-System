package com.fsoft.gst.ptithcm.tms.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * The Class MyUserDetails.
 */
public class MyUserDetails extends User {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The user. */
	private Users user;

	/**
	 * Instantiates a new my user details.
	 *
	 * @param username the username
	 * @param password the password
	 * @param enabled the enabled
	 * @param accountNonExpired the account non expired
	 * @param credentialsNonExpired the credentials non expired
	 * @param accountNonLocked the account non locked
	 * @param authorities the authorities
	 */
	public MyUserDetails(String username, String password, boolean enabled, boolean accountNonExpired,
							boolean credentialsNonExpired, boolean accountNonLocked,
							Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}
	
	/**
	 * Instantiates a new my user details.
	 *
	 * @param users the users
	 * @param authorities the authorities
	 */
	public MyUserDetails(Users users,Collection<? extends GrantedAuthority> authorities){
		super(users.getUsername(), users.getPassword(),authorities);
		this.user = users;
	}

	

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public Users getUser() {
		return user;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.User#getUsername()
	 */
	@Override
	public String getUsername() {
		return user.getUsername();
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.User#getPassword()
	 */
	@Override
	public String getPassword() {
		return user.getPassword();
	}




}