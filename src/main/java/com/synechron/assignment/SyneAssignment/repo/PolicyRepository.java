package com.synechron.assignment.SyneAssignment.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synechron.assignment.SyneAssignment.entity.HealthInsurance;
import com.synechron.assignment.SyneAssignment.entity.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Long> {

	List<Policy> findByHealthInsuranceAndIsActive(HealthInsurance thehealthInsurance, boolean b);

}
