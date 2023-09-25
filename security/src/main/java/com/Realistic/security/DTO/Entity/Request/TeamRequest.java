package com.Realistic.security.DTO.Entity.Request;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamRequest {
    private String name;
    private String coach;
    private String player;
    private String stadium;
}
