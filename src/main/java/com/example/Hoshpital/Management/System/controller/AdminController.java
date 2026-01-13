package com.example.Hoshpital.Management.System.controller;

import com.example.Hoshpital.Management.System.entity.type.RoleType;
import com.example.Hoshpital.Management.System.service.AdminService;
import com.example.Hoshpital.Management.System.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;
    private final PatientService patientService;

//    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/assignRoles/{userId}")
    public ResponseEntity<String> addRole(@PathVariable Long userId, @RequestParam String roleType) {

        RoleType role = RoleType.valueOf(roleType.toUpperCase());

        return ResponseEntity.ok(adminService.createRole(userId, role));
    }

    @DeleteMapping("/patient/{id}")
    public ResponseEntity<Void> deleteDataById(@PathVariable Long id) {
        patientService.deletePatientData(id);
        return ResponseEntity.noContent().build();
    }
}
