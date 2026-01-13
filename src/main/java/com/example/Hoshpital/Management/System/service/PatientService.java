package com.example.Hoshpital.Management.System.service;

import java.util.List;
import java.util.Map;

import com.example.Hoshpital.Management.System.entity.Patient;
import com.example.Hoshpital.Management.System.modal.PatientDto;
import org.springframework.security.access.prepost.PreAuthorize;


public interface PatientService {

    @PreAuthorize("hasRole('ADMIN')")
    List<PatientDto> getAllPatient();

    @PreAuthorize("hasRole('ADMIN')")
    PatientDto getPatientById(Long id);

    @PreAuthorize("hasAnyRole('ADMIN','PATIENT') and hasAuthority('PATIENT_WRITE')")
    PatientDto addPatientData(PatientDto patientDto, Long userId);

    @PreAuthorize("(hasRole('ADMIN') and  hasAuthority('PATIENT_WRITE')) or (hasRole('PATIENT') and #id == authentication.principal.id)")
    PatientDto updatePatientData(Long id, PatientDto patientDto);

    @PreAuthorize("hasRole('ADMIN')")
    void deletePatientData(Long id);

    @PreAuthorize("hasRole('ADMIN') or (hasRole('PATIENT') and #id == authentication.principal.id)")
    PatientDto partialUpdateData(Long id, Map<String, Object> updates);
}
