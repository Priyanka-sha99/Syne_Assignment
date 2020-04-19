package com.synechron.assignment.SyneAssignment.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synechron.assignment.SyneAssignment.entity.HealthInsurance;
import com.synechron.assignment.SyneAssignment.entity.Policy;
import com.synechron.assignment.SyneAssignment.repo.HealthInsuranceRepository;
import com.synechron.assignment.SyneAssignment.repo.PolicyRepository;

@Service
public class HealthInsuranceServiceImpl implements HealthInsuranceService {

	@Autowired
	private HealthInsuranceRepository healthInsuranceRepo;
	
	@Autowired
	private PolicyRepository policyRepo;
	
	@Override
	public void save(HealthInsurance thehealthInsurance) {
		
		healthInsuranceRepo.save(thehealthInsurance);
		
	}

	@Override
	public List<HealthInsurance> findAll() {
		
		return healthInsuranceRepo.findAll();
	}

	@Override
	public HealthInsurance findById(long companyID) {
		
		Optional<HealthInsurance> result = healthInsuranceRepo.findById(companyID);
		
		return result.isPresent()? result.get(): null;
	}

	@Override
	public void deleteById(long companyID) {
		
		healthInsuranceRepo.deleteById(companyID);
		
	}

	@Override
	public List<Policy> findByHealthInsuranceAndIsActive(HealthInsurance thehealthInsurance, boolean b) {
		
		return policyRepo.findByHealthInsuranceAndIsActive(thehealthInsurance, b);
	}


	
	

}
