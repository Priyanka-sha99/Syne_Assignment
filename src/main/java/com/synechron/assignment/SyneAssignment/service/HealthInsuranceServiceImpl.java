package com.synechron.assignment.SyneAssignment.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synechron.assignment.SyneAssignment.entity.Policy;
import com.synechron.assignment.SyneAssignment.repo.HealthInsuranceRepository;

@Service
public class HealthInsuranceServiceImpl implements HealthInsuranceService {

	@Autowired
	private HealthInsuranceRepository healthInsuranceRepo;
	
	
	
	@Override
	public void save(Policy thepolicy) {
		
		healthInsuranceRepo.save(thepolicy);
		
	}

	@Override
	public List<Policy> findAll() {
		
		return healthInsuranceRepo.findAll();
	}

	@Override
	public Policy findById(long companyID) {
		
		Optional<Policy> result = healthInsuranceRepo.findById(companyID);
		
		return result.isPresent()? result.get(): null;
	}

	@Override
	public void deleteById(long companyID) {
		
		healthInsuranceRepo.deleteById(companyID);
		
	}

	@Override
	public List<Policy> findByHealthInsuranceAndIsActive(Policy thePolicy, boolean b) {
		
		//return healthInsuranceRepo.findByHealthInsuranceAndIsActive(thePolicy, b);
		return null;
	}

	@Override
	public Policy findByCompanyName(String companyName) {
		
		//Optional<Policy> result = healthInsuranceRepo.findByCompanyName(companyName);
		
		//return result.isPresent()? result.get(): null;
		return null;
	}

	@Override
	public Policy findByPlanTypeAndAgeGroupAndCoverAndIsActive(String planType, String ageGroup, Long cover,
			boolean b) {
		
		return healthInsuranceRepo.findByPlanTypeAndAgeGroupAndCoverAndIsActive(planType,ageGroup,cover,b);
	}

	@Override
	public List<Policy> findByPlanTypeAndAgeGroupAndIsActive(String planType, String ageGroup, boolean b) {
		
		return healthInsuranceRepo.findByPlanTypeAndAgeGroupAndIsActive(planType,ageGroup,b);
	}


	
	

}
