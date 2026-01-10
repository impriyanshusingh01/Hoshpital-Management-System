package com.example.Hoshpital.Management.System.modal;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupUserDto {
    private Long id;
    private String username;
    private String password;

   public SignupUserDto(Long id, String username){
        this.id = id;
        this.username = username;
    }
}

