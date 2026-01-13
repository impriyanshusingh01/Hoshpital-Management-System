package com.example.Hoshpital.Management.System.service.Impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.Hoshpital.Management.System.entity.User;
import com.example.Hoshpital.Management.System.entity.type.BloodGroupType;
import com.example.Hoshpital.Management.System.repository.AuthRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Hoshpital.Management.System.entity.Patient;
import com.example.Hoshpital.Management.System.modal.PatientDto;
import com.example.Hoshpital.Management.System.repository.PatientRepository;
import com.example.Hoshpital.Management.System.service.PatientService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final AuthRepository authRepository;

    @Override
    public List<PatientDto> getAllPatient() {
        List<Patient> patientList = patientRepository.findAll();
        List<PatientDto> patientDto = new ArrayList<>();
        for (Patient patient : patientList) {
            patientDto.add(new PatientDto(patient.getId(),
                    patient.getName(),
                    patient.getEmail(),
                    patient.getAge(), patient.getGender(),
                    patient.getBirthDate(),
                    patient.getCreatedAt(),
                    patient.getBloodGroupType()));
        }
        return patientDto;
    }

    @Override
    public PatientDto getPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id not found" + id));
        PatientDto patientDto = new PatientDto();
        patientDto.setId(patient.getId());
        patientDto.setName(patient.getName());
        patientDto.setAge(patient.getAge());
        patientDto.setEmail(patient.getEmail());
        patientDto.setGender(patient.getGender());
        patientDto.setBirthDate(patient.getBirthDate());
        patientDto.setBloodGroupType(patient.getBloodGroupType());
        patientDto.setCreatedAt(patient.getCreatedAt());

        return patientDto;
    }

    @Override
    public PatientDto addPatientData(PatientDto patientDto, Long userId) {

        User user = authRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("user id not found " + userId));

        Patient patient = new Patient();
        patient.setUser(user);
        patient.setName(patientDto.getName());
        patient.setAge(patientDto.getAge());
        patient.setEmail(patientDto.getEmail());
        patient.setGender(patientDto.getGender());
        patient.setBirthDate(patientDto.getBirthDate());
        patient.setBloodGroupType(patientDto.getBloodGroupType());

        Patient patient1 = patientRepository.save(patient);
        return new PatientDto(patient1.getId(),
                patient1.getName(),
                patient1.getAge(),
                patient1.getGender(),
                patient1.getEmail(),
                patient1.getBirthDate(),
                patient1.getCreatedAt(),
                patient1.getBloodGroupType());
    }

    @Override
    public PatientDto updatePatientData(Long id, PatientDto patientDto) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("id not exist" + id));
        patient.setName(patientDto.getName());
        patient.setAge(patientDto.getAge());
        patient.setEmail(patientDto.getEmail());
        patient.setGender(patientDto.getGender());
        patient.setBirthDate(patientDto.getBirthDate());
        patient.setBloodGroupType(patientDto.getBloodGroupType());

        Patient patient1 = patientRepository.save(patient);
        return new PatientDto(patient1.getId(),
                patient1.getName(),
                patient1.getAge(),
                patient1.getGender(),
                patient1.getEmail(),
                patient1.getBirthDate(),
                patient1.getCreatedAt(),
                patient1.getBloodGroupType());


    }

    @Override
    public void deletePatientData(Long id) {
        if (!patientRepository.existsById(id)) {
            throw new IllegalArgumentException("id not found " + id);
        }
        patientRepository.deleteById(id);
    }

    @Override
    public PatientDto partialUpdateData(Long id, Map<String, Object> updates) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("id not exist " + id));

        for (Map.Entry<String, Object> e : updates.entrySet()) {
            String key = e.getKey();
            Object value = e.getValue();
            switch (key) {
                case "name":
                    patient.setName((String) value);
                    break;
                case "email":
                    patient.setEmail((String) value);
                    break;
                case "gender":
                    patient.setGender((String) value);
                    break;
                case "birthDate":
                    patient.setBirthDate(LocalDate.parse((String) value));
                    break;
                case "age":
                    patient.setAge((String) value);
                    break;
                case "bloodGroupType":
                    patient.setBloodGroupType(BloodGroupType.valueOf((String) value));
                    break;
                default:
                    throw new IllegalArgumentException("data not exist");
            }
        }
        Patient patient1 = patientRepository.save(patient);
        return new PatientDto(patient1.getId(),
                patient1.getName(),
                patient1.getAge(),
                patient1.getGender(),
                patient1.getEmail(),
                patient1.getBirthDate(),
                patient1.getCreatedAt(),
                patient1.getBloodGroupType());

    }


}
