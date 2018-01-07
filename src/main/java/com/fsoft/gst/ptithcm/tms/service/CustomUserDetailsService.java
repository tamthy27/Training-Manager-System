package com.fsoft.gst.ptithcm.tms.service;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fsoft.gst.ptithcm.tms.model.CustomUserDetails;
import com.fsoft.gst.ptithcm.tms.model.Role;
import com.fsoft.gst.ptithcm.tms.model.RolePermisstion;
import com.fsoft.gst.ptithcm.tms.model.Users;
import com.fsoft.gst.ptithcm.tms.reposity.UsersRepository;

/**
 * The Class CustomUserDetailsService.
 */
@Service("customUserDetailsService")
@Transactional()
public class CustomUserDetailsService implements UserDetailsService {

	/** The users repository. */
	@Autowired
	private UsersRepository usersRepository;

	/* 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		try {
			Users user = usersRepository.findByUsername(username);

			boolean enabled = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;
			Set<Role> roles = new HashSet<Role>(0);
			roles.add(user.getRole());
			// adapt as needed
			return new CustomUserDetails(user, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, getAuthorities(roles));

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * The Class SimpleGrantedAuthorityComparator.
	 */
	private static class SimpleGrantedAuthorityComparator implements Comparator<SimpleGrantedAuthority> {

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(SimpleGrantedAuthority o1, SimpleGrantedAuthority o2) {
			return o1.equals(o2) ? 0 : -1;
		}
	}

	/**
	 * Retrieves a collection of {@link GrantedAuthority} based on a list of
	 * roles.
	 *
	 * @param roles
	 *            the assigned roles of the user
	 * @return a collection of {@link GrantedAuthority}
	 */
	public Collection<? extends GrantedAuthority> getAuthorities(Set<Role> roles) {

		Set<SimpleGrantedAuthority> authList = new TreeSet<SimpleGrantedAuthority>(new SimpleGrantedAuthorityComparator());

		for (Role role : roles) {
			authList.addAll(getGrantedAuthorities(role));
		}

		return authList;
	}

	/**
	 * Get List Permisstion Wraps a {@link Role} role to
	 * {@link SimpleGrantedAuthority} objects.
	 *
	 * @param role
	 *            the role
	 * @return list of granted authorities
	 */
	public static Set<SimpleGrantedAuthority> getGrantedAuthorities(Role role) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();
		Set<RolePermisstion> rolePermissions = role.getRolePermisstions();
		for (RolePermisstion permission : rolePermissions) {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + permission.getPermission().getName()));
		}

		return authorities;
	}

}