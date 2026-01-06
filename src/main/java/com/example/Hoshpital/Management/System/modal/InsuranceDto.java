package com.example.Hoshpital.Management.System.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceDto {

    private Long id;
    private String policyNumber;
    private String provider;
    private LocalDate validUntil;
    private LocalDateTime createdAt;

}
