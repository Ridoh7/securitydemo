package com.Realistic.security.Repository;

import com.Realistic.security.User.Admin;
import com.Realistic.security.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepo extends JpaRepository<Admin, Integer> {
    Optional<Admin> findByEmail(String email);

}
