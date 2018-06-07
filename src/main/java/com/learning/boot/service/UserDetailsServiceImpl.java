package com.learning.boot.service;

import com.learning.boot.model.PortalUser;
import com.learning.boot.model.Role;
import com.learning.boot.repository.PortalUserRepository;
import com.learning.boot.repository.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PortalUserRepository portalUserRepository;

    @Autowired
    private RoleRepository roleRepository;

    public static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PortalUser portalUser = portalUserRepository.findByPortalUserLogin(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        if(portalUser != null)
        for (Role role : portalUser.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        else{
            throw new UsernameNotFoundException(username + " is not found");
        }

        return new User(portalUser.getPortalUserLogin(), portalUser.getPortalUserPassword(), grantedAuthorities);
    }
}
