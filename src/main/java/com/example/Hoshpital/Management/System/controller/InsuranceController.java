package com.example.Hoshpital.Management.System.controller;

import com.example.Hoshpital.Management.System.modal.InsuranceDto;
import com.example.Hoshpital.Management.System.service.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class InsuranceController {

    private  final InsuranceService insuranceService;

    @GetMapping("/insurances")
    public ResponseEntity<List<InsuranceDto>> getAlInsurance() {
        return ResponseEntity.ok(insuranceService.getAllInsurance());
    }

    @PutMapping("/insurance/{patientId}")
    public ResponseEntity<InsuranceDto> assignInsurance(
            @PathVariable Long patientId,
            @RequestBody InsuranceDto insuranceDto) {
       return ResponseEntity.ok(insuranceService.assignInsuranceToPatient(insuranceDto, patientId));
    }
}
