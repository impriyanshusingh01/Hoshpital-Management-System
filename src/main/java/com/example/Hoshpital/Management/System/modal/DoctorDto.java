package com.example.Hoshpital.Management.System.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class DoctorDto {

    private Long id;
    private String name;
    private String specialization;
    private String email;
}
