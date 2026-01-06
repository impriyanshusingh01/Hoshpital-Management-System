package com.example.Hoshpital.Management.System.controller;

import com.example.Hoshpital.Management.System.modal.PatientDto;
import com.example.Hoshpital.Management.System.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/patients")
    public ResponseEntity<List<PatientDto>> getAllPatient() {
        return ResponseEntity.ok(patientService.getAllPatient());
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.getPatientById(id));
    }

    @PostMapping("/patient")
    public ResponseEntity<PatientDto> addPatientData(@RequestBody PatientDto patientDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.addPatientData(patientDto));
    }

    @PutMapping("/patient/{id}")
    public ResponseEntity<PatientDto> updatePatientData(@PathVariable Long id, @RequestBody PatientDto patientDto) {
        return ResponseEntity.ok(patientService.updatePatientData(id, patientDto));
    }

    @DeleteMapping("/patient/{id}")
    public ResponseEntity<Void> deleteDataById(@PathVariable Long id) {
        patientService.deletePatientData(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/patient/{id}")
    public ResponseEntity<PatientDto> partialUpdateData(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        return ResponseEntity.ok(patientService.partialUpdateData(id, updates));
    }
}
