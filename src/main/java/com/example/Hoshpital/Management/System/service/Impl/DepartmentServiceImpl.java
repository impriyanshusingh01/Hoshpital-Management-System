package com.example.Hoshpital.Management.System.service.Impl;

import com.example.Hoshpital.Management.System.entity.Department;
import com.example.Hoshpital.Management.System.entity.Doctor;
import com.example.Hoshpital.Management.System.modal.DepartmentDto;
import com.example.Hoshpital.Management.System.repository.DepartmentRepository;
import com.example.Hoshpital.Management.System.repository.DoctorRepository;
import com.example.Hoshpital.Management.System.service.DepartmentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DoctorRepository doctorRepository;

    @Override
    public List<DepartmentDto> getAllDepartmentList() {
        List<Department> departmentList = departmentRepository.findAll();
        List<DepartmentDto> departmentDto = new ArrayList<>();
        for(Department department: departmentList){
            departmentDto.add(new DepartmentDto(department.getId(),department.getName()));
        }
        return departmentDto;
    }

    @Override
    public DepartmentDto addDepartment(Long doctorId, DepartmentDto departmentDto) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(()-> new EntityNotFoundException("id not found"+doctorId));
        Department department = new Department();
        department.setName(departmentDto.getName());
        department.getDoctors().add(doctor);
        doctor.getDepartments().add(department);

        Department department1 = departmentRepository.save(department);
        return new DepartmentDto(department1.getId(), department1.getName());
    }

    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto departmentDto) {
       Department department = departmentRepository.findById(departmentId)
               .orElseThrow(()-> new IllegalArgumentException("id not found: "+departmentId));
       department.setName(departmentDto.getName());
       Department department1 = departmentRepository.save(department);

       return new DepartmentDto(department1.getId(), department1.getName());
    }
}
