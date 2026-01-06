package com.example.Hoshpital.Management.System.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto {

    private Long id;
    private LocalDateTime appointmentTime;
    private String reason;
}
