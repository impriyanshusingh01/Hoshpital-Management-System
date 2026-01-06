package com.example.Hoshpital.Management.System.service;

import com.example.Hoshpital.Management.System.entity.Insurance;
import com.example.Hoshpital.Management.System.entity.Patient;
import com.example.Hoshpital.Management.System.modal.InsuranceDto;
import com.example.Hoshpital.Management.System.modal.PatientDto;

import java.util.List;

public interface InsuranceService {
List<InsuranceDto> getAllInsurance();
InsuranceDto assignInsuranceToPatient(InsuranceDto insuranceDto, Long patientId);
}
