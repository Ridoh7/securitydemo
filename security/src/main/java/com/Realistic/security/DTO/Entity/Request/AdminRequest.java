package com.Realistic.security.DTO.Entity.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminRequest {
        private String firstName;
        private String lastName;
        private String email;
        private String password;
}
