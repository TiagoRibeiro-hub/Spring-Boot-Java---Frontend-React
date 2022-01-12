package com.devSR.dsmovie.repositories;

import com.devSR.dsmovie.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByEmail(String Email);
}
