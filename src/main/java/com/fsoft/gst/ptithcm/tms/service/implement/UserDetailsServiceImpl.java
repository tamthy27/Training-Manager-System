package com.fsoft.gst.ptithcm.tms.service.implement;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fsoft.gst.ptithcm.tms.model.MyUserDetails;
import com.fsoft.gst.ptithcm.tms.model.Role;
import com.fsoft.gst.ptithcm.tms.model.Users;
import com.fsoft.gst.ptithcm.tms.reposity.UsersRepository;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
    	
    	
    	
        Users user = usersRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Role roles = user.getRole();
    
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+roles.getRoleName().trim().toUpperCase()));
//        for (Role role : roles) {
//        }
//        MyUserDetails myUserDetails = new MyUserDetails();
//        myUserDetails.s
        MyUserDetails userDetails = new MyUserDetails(user, grantedAuthorities);
//        MyUserDetails myUserDetails = (MyUserDetails) new User(user.getUsername(),user.getPassword(),grantedAuthorities);
        return userDetails;
                
    }

}