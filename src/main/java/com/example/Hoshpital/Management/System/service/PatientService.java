package com.example.Hoshpital.Management.System.service;

import java.util.List;
import java.util.Map;

import com.example.Hoshpital.Management.System.entity.Patient;
import com.example.Hoshpital.Management.System.modal.PatientDto;


public interface PatientService {
    List<PatientDto> getAllPatient();
    PatientDto getPatientById(Long id);
    PatientDto addPatientData(PatientDto patientDto);
    PatientDto updatePatientData(Long id, PatientDto patientDto);
    void deletePatientData(Long id);

    PatientDto partialUpdateData(Long id, Map<String, Object> updates);
}
