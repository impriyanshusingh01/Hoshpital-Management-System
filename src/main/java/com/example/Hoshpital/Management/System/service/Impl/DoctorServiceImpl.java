package com.example.Hoshpital.Management.System.service.Impl;

import com.example.Hoshpital.Management.System.entity.Doctor;
import com.example.Hoshpital.Management.System.modal.DoctorDto;
import com.example.Hoshpital.Management.System.repository.DoctorRepository;
import com.example.Hoshpital.Management.System.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public List<DoctorDto> getAllDoctorList() {
       List<Doctor> doctorList = doctorRepository.findAll();
       List<DoctorDto> doctor = new ArrayList<>();

       for(Doctor doc: doctorList){
           doctor.add(new DoctorDto(doc.getId(), doc.getName(), doc.getEmail(), doc.getSpecialization()));
       }

       return doctor;
    }

    @Override
    public DoctorDto addDoctor(DoctorDto doctorDto) {
      Doctor doctor = new Doctor();
      doctor.setName(doctorDto.getName());
      doctor.setSpecialization(doctorDto.getSpecialization());
      doctor.setEmail(doctorDto.getEmail());

      Doctor doctor1 = doctorRepository.save(doctor);

      return new DoctorDto(doctor1.getId(), doctor1.getName(), doctor1.getSpecialization(),doctor1.getEmail());
    }
}
