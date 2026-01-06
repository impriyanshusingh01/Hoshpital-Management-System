package com.example.Hoshpital.Management.System.modal;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.Hoshpital.Management.System.entity.type.BloodGroupType;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PatientDto {

    private Long id;

    private String name;
    private String age;
    private String gender;
    private String email;
    private LocalDate birthDate;
    private LocalDateTime createdAt;

    private BloodGroupType bloodGroupType;


}
