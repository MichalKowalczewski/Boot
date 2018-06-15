package com.learning.boot.repository;

import com.learning.boot.model.PortalUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortalUserRepository extends JpaRepository<PortalUser, Integer> {
    PortalUser findByPortalUserEmail(String email);
    PortalUser findByPortalUserLogin(String login);
    PortalUser findByPortalUserID(int id);
}
