package com.synechron.assignment.SyneAssignment.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.synechron.assignment.SyneAssignment.entity.HealthInsurance;
import com.synechron.assignment.SyneAssignment.entity.Policy;
import com.synechron.assignment.SyneAssignment.exceptionHandling.ObjectNotFoundException;
import com.synechron.assignment.SyneAssignment.service.HealthInsuranceService;


@RestController
@CrossOrigin(origins="*")
@RequestMapping("/healthInsurances")
public class HealthInsuranceController {
	
	@Autowired
	private HealthInsuranceService healthInsuranceService;
	
	
	//save the company and policy
	@PostMapping
	public String savePlans(@RequestBody HealthInsurance thehealthInsurance)
	{
		
		thehealthInsurance.setCompanyId(0);
		
		healthInsuranceService.save(thehealthInsurance);
		
		return "Health Insurance Plan added successfully";
	}
	
	//get all companies
	@GetMapping
	public List<HealthInsurance> getAllPlans() throws ObjectNotFoundException
	{
		List<HealthInsurance> healthInsurance = healthInsuranceService.findAll();
		
		if(healthInsurance.size() == 0)
		{
			throw new ObjectNotFoundException("No Insurance Plans exists");
		}
		return healthInsurance;
		
	}
	
	//to get all the policies that are active by companyID
	@GetMapping("/{companyID}")
	public List<Policy> getPlansByID(@PathVariable long companyID) throws ObjectNotFoundException
	{
		
		HealthInsurance thehealthInsurance = healthInsuranceService.findById(companyID);
		
		if(thehealthInsurance == null)
		{
			throw new ObjectNotFoundException(" HealthInsurance company of ID is not present " +companyID);
		}
		
		//to check active policy
		List<Policy> policy = healthInsuranceService.findByHealthInsuranceAndIsActive(thehealthInsurance,true);
		
		if(policy.size() == 0)
		{
			
		throw new ObjectNotFoundException(" No active policy for Company " +thehealthInsurance.getCompanyName());
		}
		
		return policy;
		
	}
	
	
		
	//to update company
	@PutMapping
	public HealthInsurance updatePlans(@RequestBody HealthInsurance thehealthInsurance)
	{
		healthInsuranceService.save(thehealthInsurance);
		
		return thehealthInsurance;
	}
	
	//to delete company
	@DeleteMapping("/{companyID}")
	public String deletePlans(@PathVariable long companyID) throws ObjectNotFoundException
	{
		
		HealthInsurance thehealthInsurance = healthInsuranceService.findById(companyID);
		
		if(thehealthInsurance == null)
		{
			throw new ObjectNotFoundException(" HealthInsurance company of ID is not present " +companyID);
		}
		
		healthInsuranceService.deleteById(companyID);
		
		return "HealthInsurance company  deleted of Id- " +companyID;
	}
	
	
	
	

}
