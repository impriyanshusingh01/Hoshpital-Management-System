package com.example.Hoshpital.Management.System.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenResponseDto {

    String jwtSecretKey;
    Long userId;
}
