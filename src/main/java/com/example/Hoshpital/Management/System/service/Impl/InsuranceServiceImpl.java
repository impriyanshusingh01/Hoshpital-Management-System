package com.example.Hoshpital.Management.System.service.Impl;

import com.example.Hoshpital.Management.System.entity.Insurance;
import com.example.Hoshpital.Management.System.entity.Patient;
import com.example.Hoshpital.Management.System.modal.InsuranceDto;
import com.example.Hoshpital.Management.System.modal.PatientDto;
import com.example.Hoshpital.Management.System.repository.InsuranceRepository;
import com.example.Hoshpital.Management.System.repository.PatientRepository;
import com.example.Hoshpital.Management.System.service.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InsuranceServiceImpl implements InsuranceService {

    private  final InsuranceRepository insuranceRepository;
    private  final PatientRepository patientRepository;

    @Override
    public List<InsuranceDto> getAllInsurance() {
        List<Insurance> insuranceList = insuranceRepository.findAll();
        List<InsuranceDto> insuranceDto = new ArrayList<>();

        for(Insurance insurance : insuranceList){
            insuranceDto.add(new InsuranceDto(insurance.getId(),
                    insurance.getPolicyNumber(),
                    insurance.getProvider(),
                    insurance.getValidUntil(),
                    insurance.getCreatedAt()));
        }

        return insuranceDto;

    }

    @Override
    public InsuranceDto assignInsuranceToPatient(InsuranceDto insuranceDto, Long patientId) {
       Patient patient = patientRepository.findById(patientId)
               .orElseThrow(()-> new IllegalArgumentException("id not found: " + patientId));

        Insurance insurance = new Insurance();
        insurance.setPatient(patient);
        insurance.setProvider(insuranceDto.getProvider());
        insurance.setPolicyNumber(insuranceDto.getPolicyNumber());
        insurance.setValidUntil(insuranceDto.getValidUntil());

        patient.setInsurance(insurance); // link insurance to patient
        Patient savedPatient = patientRepository.save(patient);

        return new InsuranceDto(
                savedPatient.getInsurance().getId(),
                savedPatient.getInsurance().getPolicyNumber(),
                savedPatient.getInsurance().getProvider(),
                savedPatient.getInsurance().getValidUntil(),
                savedPatient.getInsurance().getCreatedAt() );


    }
}
