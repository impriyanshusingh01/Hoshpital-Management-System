package com.example.Hoshpital.Management.System.repository;

import com.example.Hoshpital.Management.System.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}
