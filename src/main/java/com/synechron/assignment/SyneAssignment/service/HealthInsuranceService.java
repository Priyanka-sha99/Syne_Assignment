package com.synechron.assignment.SyneAssignment.service;

import java.util.List;

import com.synechron.assignment.SyneAssignment.entity.Policy;

public interface HealthInsuranceService {

	public void save(Policy thePolicy);

	public List<Policy> findAll();

	public Policy findById(long companyID);

	public void deleteById(long companyID);

	public List<Policy> findByHealthInsuranceAndIsActive(Policy thepolicy, boolean b);

	public Policy findByCompanyName(String companyName);

	public Policy findByPlanTypeAndAgeGroupAndCoverAndIsActive(String planType, String ageGroup, Long cover, boolean b);

	public List<Policy> findByPlanTypeAndAgeGroupAndIsActive(String planType, String ageGroup, boolean b);
	

}
