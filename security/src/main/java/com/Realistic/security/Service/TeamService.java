package com.Realistic.security.Service;

import com.Realistic.security.DTO.Entity.Request.TeamRequest;
import com.Realistic.security.DTO.Entity.Team;

import java.util.List;

public interface TeamService {
    String registerTeam(TeamRequest teamRequest);
    public List<Team> listAllTeam();
}
