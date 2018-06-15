package com.learning.boot.service;

import com.learning.boot.model.PortalUser;

import java.util.List;

public interface PortalUserService {

    public void save(PortalUser portalUser);
    public void update(PortalUser portalUser);

    PortalUser findByLogin(String username);
    PortalUser findById(int id);
}



