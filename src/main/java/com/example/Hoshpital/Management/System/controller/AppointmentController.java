package com.example.Hoshpital.Management.System.controller;

import com.example.Hoshpital.Management.System.modal.AppointmentDto;
import com.example.Hoshpital.Management.System.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping("/appointments")
    public ResponseEntity<List<AppointmentDto>> getAllAppointment() {
        return ResponseEntity.ok(appointmentService.getAllAppointment());
    }

    @PostMapping("/appointment/{patientId}")
    public ResponseEntity<AppointmentDto> addAppointment(@PathVariable("patientId") Long patientId ,@RequestBody AppointmentDto appointmentDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.addAppointment(appointmentDto, patientId));
    }

    @PutMapping("/appointment/{appointmentId}")
    public ResponseEntity<AppointmentDto> updateAppointment(@PathVariable Long appointmentId ,@RequestBody AppointmentDto appointmentDto) {
        return ResponseEntity.ok(appointmentService.updateAppointment(appointmentId, appointmentDto));
    }

    @PutMapping("/doctorAppointment/{appointmentId}/{doctorId}")
    public ResponseEntity<AppointmentDto> updateDoctorAppointment(@PathVariable Long appointmentId, @PathVariable Long doctorId) {
        return ResponseEntity.ok(appointmentService.updateDoctorAppointment(appointmentId, doctorId));
    }
}
