package com.example.Hoshpital.Management.System.controller;

import com.example.Hoshpital.Management.System.modal.DoctorDto;
import com.example.Hoshpital.Management.System.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping("/doctors")
    public ResponseEntity<List<DoctorDto>> getAllDoctorList(){
        return ResponseEntity.ok(doctorService.getAllDoctorList());
    }

    @PostMapping("/doctor")
    public ResponseEntity<DoctorDto> createDoctor(@RequestBody DoctorDto doctorDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorService.addDoctor(doctorDto));
    }

}
