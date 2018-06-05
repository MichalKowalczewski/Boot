package com.learning.boot.service;

import com.learning.boot.model.PortalUser;
import com.learning.boot.model.Role;
import com.learning.boot.repository.PortalUserRepository;
import com.learning.boot.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PortalUserServiceImpl implements PortalUserService {

    @Autowired
    private PortalUserRepository portalUserRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(PortalUser portalUser){
        portalUser.setPortalUserPassword(bCryptPasswordEncoder.encode(portalUser.getPortalUserPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByRoleName("USER"));
        portalUser.setRoles(roles);
        portalUserRepository.save(portalUser);
    }


    @Override
    public PortalUser findByLogin(String username) {
        return portalUserRepository.findByPortalUserLogin(username);
    }
}
