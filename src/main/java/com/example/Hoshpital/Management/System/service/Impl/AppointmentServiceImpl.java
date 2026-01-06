package com.example.Hoshpital.Management.System.service.Impl;

import com.example.Hoshpital.Management.System.entity.Appointment;
import com.example.Hoshpital.Management.System.entity.Doctor;
import com.example.Hoshpital.Management.System.entity.Patient;
import com.example.Hoshpital.Management.System.modal.AppointmentDto;
import com.example.Hoshpital.Management.System.repository.AppointmentRepository;
import com.example.Hoshpital.Management.System.repository.DoctorRepository;
import com.example.Hoshpital.Management.System.repository.PatientRepository;
import com.example.Hoshpital.Management.System.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Override
    public List<AppointmentDto> getAllAppointment() {
        List<Appointment> appointments = appointmentRepository.findAll();
        List<AppointmentDto> appointmentDto = new ArrayList<>();

        for(Appointment appointment: appointments){
            appointmentDto.add(new AppointmentDto(appointment.getId(), appointment.getAppointmentTime(), appointment.getReason()));
        }

        return appointmentDto;
    }

    @Override
    public AppointmentDto addAppointment(AppointmentDto appointmentDto, Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(()-> new IllegalArgumentException("id not found" + patientId));
     Appointment appointment = new Appointment();
     appointment.setAppointmentTime(appointmentDto.getAppointmentTime());
     appointment.setReason(appointmentDto.getReason());
     appointment.setPatient(patient);

     Appointment appointment1 = appointmentRepository.save(appointment);

     return new AppointmentDto(appointment1.getId(), appointment1.getAppointmentTime(), appointment1.getReason());
    }

    @Override
    public AppointmentDto updateAppointment(Long appointmentId, AppointmentDto appointmentDto) {
      Appointment appointmentUpdate = appointmentRepository.findById(appointmentId)
                .orElseThrow(()-> new IllegalArgumentException("id not found" + appointmentId));


        appointmentUpdate.setAppointmentTime(appointmentDto.getAppointmentTime());
        appointmentUpdate.setReason(appointmentDto.getReason());


        Appointment appointment = appointmentRepository.save(appointmentUpdate);

        return new AppointmentDto(appointment.getId(), appointment.getAppointmentTime(), appointment.getReason());
    }

    @Override
    public AppointmentDto updateDoctorAppointment(Long appointmentId, Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(()-> new IllegalArgumentException("id not found: "+doctorId));

        Appointment appointment =  appointmentRepository.findById(appointmentId)
                        .orElseThrow(()-> new IllegalArgumentException("id not found: "+appointmentId));
        appointment.setDoctor(doctor);

        doctor.getAppointments().add(appointment);

        Appointment appointment1 = appointmentRepository.save(appointment);

        return new AppointmentDto(appointment1.getId(), appointment.getAppointmentTime(), appointment.getReason());
    }
}
