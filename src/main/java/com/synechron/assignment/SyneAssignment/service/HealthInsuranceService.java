package com.synechron.assignment.SyneAssignment.service;

import java.util.List;

import com.synechron.assignment.SyneAssignment.entity.HealthInsurance;
import com.synechron.assignment.SyneAssignment.entity.Policy;

public interface HealthInsuranceService {

	public void save(HealthInsurance thehealthInsurance);

	public List<HealthInsurance> findAll();

	public HealthInsurance findById(long companyID);

	public void deleteById(long companyID);

	public List<Policy> findByHealthInsuranceAndIsActive(HealthInsurance thehealthInsurance, boolean b);
	

}
