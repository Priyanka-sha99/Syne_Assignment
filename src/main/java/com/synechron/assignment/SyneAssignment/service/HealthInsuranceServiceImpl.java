package com.synechron.assignment.SyneAssignment.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synechron.assignment.SyneAssignment.entity.HealthInsurance;
import com.synechron.assignment.SyneAssignment.exceptionHandling.HealthInsuranceCompanyNotFoundException;
import com.synechron.assignment.SyneAssignment.repo.HealthInsuranceRepository;

@Service
public class HealthInsuranceServiceImpl implements HealthInsuranceService {

	@Autowired
	private HealthInsuranceRepository healthInsuranceRepo;
	
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
		
		HealthInsurance thehealthInsurance = null;
		
		Optional<HealthInsurance> result = healthInsuranceRepo.findById(companyID);
		
		if(result.isPresent())
		{
			thehealthInsurance = result.get();
		}
		else
		{
			throw new HealthInsuranceCompanyNotFoundException("HealthInsurance company of ID is not present- " +companyID);
		}
		return thehealthInsurance;
	}

	@Override
	public void deleteById(long companyID) {
		
		healthInsuranceRepo.deleteById(companyID);
		
	}

	/*@Override
	public HealthInsurance findByIdAndPolicyNum(long companyID, long policyNum) {
		
		return healthInsuranceRepo.findByCompanyIdAndPolicyNum(companyID, policyNum);
	}*/
	

}
