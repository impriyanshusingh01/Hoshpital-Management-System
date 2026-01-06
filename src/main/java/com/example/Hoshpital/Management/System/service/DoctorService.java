package com.example.Hoshpital.Management.System.service;

import com.example.Hoshpital.Management.System.modal.DoctorDto;

import java.util.List;

public interface DoctorService {

    List<DoctorDto> getAllDoctorList();

    DoctorDto addDoctor(DoctorDto doctorDto);
}
