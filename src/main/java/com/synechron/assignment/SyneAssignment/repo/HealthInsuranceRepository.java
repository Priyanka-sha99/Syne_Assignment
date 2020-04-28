package com.synechron.assignment.SyneAssignment.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.synechron.assignment.SyneAssignment.entity.Policy;

public interface HealthInsuranceRepository extends JpaRepository<Policy, Long> {

	
	
	//List<Policy> findByHealthInsuranceAndIsActive(Policy thehealthInsurance, boolean b);

	Policy findByPlanTypeAndAgeGroupAndCoverAndIsActive(String planType, String ageGroup, Long cover, boolean b);

	List<Policy> findByPlanTypeAndAgeGroupAndIsActive(String planType, String ageGroup, boolean b);


	

}
