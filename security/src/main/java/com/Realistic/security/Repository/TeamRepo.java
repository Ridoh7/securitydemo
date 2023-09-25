package com.Realistic.security.Repository;

import com.Realistic.security.DTO.Entity.Team;
import org.apache.coyote.Response;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeamRepo extends JpaRepository<Team, String> {
//    Optional<Team> findByName(String name);
//
//    public List<Team> fetchAllProduct(String name);

    }
