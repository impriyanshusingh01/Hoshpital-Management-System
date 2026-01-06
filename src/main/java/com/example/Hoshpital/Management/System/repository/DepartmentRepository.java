package com.example.Hoshpital.Management.System.repository;

import com.example.Hoshpital.Management.System.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
