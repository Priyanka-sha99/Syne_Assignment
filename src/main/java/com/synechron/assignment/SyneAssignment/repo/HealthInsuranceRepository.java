package com.synechron.assignment.SyneAssignment.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.synechron.assignment.SyneAssignment.entity.HealthInsurance;

public interface HealthInsuranceRepository extends JpaRepository<HealthInsurance, Long> {


	

}
