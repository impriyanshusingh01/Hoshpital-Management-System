package com.example.Hoshpital.Management.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Hoshpital.Management.System.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>  {
    
}
