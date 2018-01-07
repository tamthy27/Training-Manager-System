package com.fsoft.gst.ptithcm.tms.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

/**
 * The Class CustomUserDetails.
 */
public class CustomUserDetails implements UserDetails {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 9188230014174856593L;

    /** The user. */
    private Users user;
    
    /** The authorities. */
    private final Set<GrantedAuthority> authorities;
    
    /** The account non expired. */
    private final boolean accountNonExpired;
    
    /** The account non locked. */
    private final boolean accountNonLocked;
    
    /** The credentials non expired. */
    private final boolean credentialsNonExpired;
    
    /** The enabled. */
    private final boolean enabled;

    /**
     * Instantiates a new custom user details.
     *
     * @param user the user
     * @param authorities the authorities
     */
    public CustomUserDetails (Users user,
            Collection<? extends GrantedAuthority> authorities) {
    	
        this(user, true, true, true, true, authorities);
        
    }

    /**
     * Instantiates a new custom user details.
     *
     * @param user the user
     * @param enabled the enabled
     * @param accountNonExpired the account non expired
     * @param credentialsNonExpired the credentials non expired
     * @param accountNonLocked the account non locked
     * @param authorities the authorities
     */
    public CustomUserDetails (Users user,
            boolean enabled, boolean accountNonExpired,
            boolean credentialsNonExpired, boolean accountNonLocked,
            Collection<? extends GrantedAuthority> authorities) {

        if (((user.getUsername() == null) || "".equals(user.getUsername())) || (user.getPassword()== null)) {
            throw new IllegalArgumentException(
                    "Cannot pass null or empty values to constructor");
        }

        this.user = user;
        this.enabled = enabled;
        this.accountNonExpired = accountNonExpired;
        this.credentialsNonExpired = credentialsNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.authorities = Collections
                .unmodifiableSet(sortAuthorities(authorities));
    }

    /**
     * Sort authorities.
     *
     * @param authorities the authorities
     * @return the sorted set
     */
    private static SortedSet<GrantedAuthority> sortAuthorities(
            Collection<? extends GrantedAuthority> authorities) {
        Assert.notNull(authorities,
                "Cannot pass a null GrantedAuthority collection");
        // Ensure array iteration order is predictable (as per
        // UserDetails.getAuthorities() contract and SEC-717)
        SortedSet<GrantedAuthority> sortedAuthorities = new TreeSet<GrantedAuthority>(
                new AuthorityComparator());

        for (GrantedAuthority grantedAuthority : authorities) {
            Assert.notNull(grantedAuthority,
                    "GrantedAuthority list cannot contain any null elements");
            sortedAuthorities.add(grantedAuthority);
        }

        return sortedAuthorities;
    }

    /**
     * The Class AuthorityComparator.
     */
    private static class AuthorityComparator implements
            Comparator<GrantedAuthority>, Serializable {
        
        /** The Constant serialVersionUID. */
        private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

        
        /* 
         * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
         */
        public int compare(GrantedAuthority g1, GrantedAuthority g2) {
            // Neither should ever be null as each entry is checked before
            // adding it to
            // the set.
            // If the authority is null, it is a custom authority and should
            // precede
            // others.
            if (g2.getAuthority() == null) {
                return -1;
            }

            if (g1.getAuthority() == null) {
                return 1;
            }

            return g1.getAuthority().compareTo(g2.getAuthority());
        }
    }

    /* (non-Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetails#getPassword()
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /* (non-Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetails#getUsername()
     */
    @Override
    public String getUsername() {
        return user.getUsername();
    }

    /**
     * Gets the user.
     *
     * @return the user
     */
    public Users getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(Users user) {
		this.user = user;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
	 */
	@Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
     */
    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetails#isEnabled()
     */
    @Override
    public boolean isEnabled() {
        return enabled;
    }
}