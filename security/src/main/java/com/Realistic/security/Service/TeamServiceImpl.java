package com.Realistic.security.Service;

import com.Realistic.security.DTO.Entity.Request.TeamRequest;
import com.Realistic.security.DTO.Entity.Team;
import com.Realistic.security.Repository.TeamRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService{
    public final TeamRepo teamRepo;

    public TeamServiceImpl(TeamRepo teamRepo) {
        this.teamRepo = teamRepo;
    }

    @Override
    public String registerTeam(TeamRequest teamRequest) {
            Team team= Team.builder()
                    .coach(teamRequest.getCoach())
                    .name(teamRequest.getName())
                    .stadium(teamRequest.getStadium())
                    .player(teamRequest.getPlayer())
                    .build();

            teamRepo.save(team);
            return "team registered successfully";
    }

    @Override
    public List<Team>listAllTeam() {
        return listAllTeam();
    }
}
