package com.example.Hoshpital.Management.System.repository;

import com.example.Hoshpital.Management.System.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
