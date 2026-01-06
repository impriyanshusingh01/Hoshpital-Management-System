package com.example.Hoshpital.Management.System.controller;

import com.example.Hoshpital.Management.System.modal.DepartmentDto;
import com.example.Hoshpital.Management.System.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("/departments")
    public ResponseEntity<List<DepartmentDto>> getDepartmentList(){
        return ResponseEntity.ok(departmentService.getAllDepartmentList());
    }

    @PostMapping("/department/{doctorId}")
    public ResponseEntity<DepartmentDto> addDepartment(@PathVariable Long doctorId, @RequestBody DepartmentDto departmentDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.addDepartment(doctorId, departmentDto));
    }

    @PutMapping("/department/{departmentId}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable Long departmentId, @RequestBody DepartmentDto departmentDto){
        return ResponseEntity.ok(departmentService.updateDepartment(departmentId, departmentDto));
    }
}
