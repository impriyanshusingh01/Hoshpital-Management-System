package com.example.Hoshpital.Management.System.service;

import com.example.Hoshpital.Management.System.modal.AppointmentDto;

import java.util.List;

public interface AppointmentService {

    List<AppointmentDto> getAllAppointment();

    AppointmentDto addAppointment(AppointmentDto appointmentDto, Long patientId);

    AppointmentDto updateAppointment(Long appointmentId, AppointmentDto appointmentDto);

    AppointmentDto updateDoctorAppointment(Long appointmentId, Long doctorId);


}
