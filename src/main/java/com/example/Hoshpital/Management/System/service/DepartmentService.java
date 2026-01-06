package com.example.Hoshpital.Management.System.service;


import com.example.Hoshpital.Management.System.modal.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    List<DepartmentDto> getAllDepartmentList();
    DepartmentDto addDepartment(Long doctorId, DepartmentDto departmentDto);
    DepartmentDto updateDepartment(Long departmentId, DepartmentDto departmentDto);
}
