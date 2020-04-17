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
import com.synechron.assignment.SyneAssignment.exceptionHandling.HealthInsuranceCompanyNotFoundException;
import com.synechron.assignment.SyneAssignment.service.HealthInsuranceService;


@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/v1")
public class HealthInsuranceController {
	
	@Autowired
	private HealthInsuranceService healthInsuranceService;
	
	
	//save the company and policy
	@PostMapping("/healthInsurances")
	public String savePlans(@RequestBody HealthInsurance thehealthInsurance)
	{
		
		System.out.println(thehealthInsurance.getCompanyName());
		
		thehealthInsurance.setCompanyId(0);
		
		healthInsuranceService.save(thehealthInsurance);
		
		return "Health Insurance Plan added successfully";
	}
	
	//get all companies
	@GetMapping("/healthInsurances")
	public List<HealthInsurance> getAllPlans()
	{
		return healthInsuranceService.findAll();
	}
	
	//to get company by companyID
	@GetMapping("/healthInsurances/{companyID}")
	public HealthInsurance getPlansByID(@PathVariable long companyID)
	{
		
		HealthInsurance thehealthInsurance = healthInsuranceService.findById(companyID);
		
		if(thehealthInsurance == null)
		{
			throw new HealthInsuranceCompanyNotFoundException(" HealthInsurance company of ID is not present " +companyID);
		}
		
		return thehealthInsurance;
	}
	
	//to get all the policies of specific company
	@GetMapping("/healthInsurances/{companyID}/policy")
	public List<Policy> getPoliciesByPlanID(@PathVariable long companyID)
	{
		
		HealthInsurance thehealthInsurance = healthInsuranceService.findById(companyID);
		
		if(thehealthInsurance == null)
		{
			throw new HealthInsuranceCompanyNotFoundException(" HealthInsurance company of ID is not present " +companyID);
		}
		
		return thehealthInsurance.getPolicy();
	}
		
	//to update company
	@PutMapping("/healthInsurances")
	public HealthInsurance updatePlans(@RequestBody HealthInsurance thehealthInsurance)
	{
		healthInsuranceService.save(thehealthInsurance);
		
		System.out.println("check: " +thehealthInsurance.getPolicy());
		
		return thehealthInsurance;
	}
	
	//to delete company
	@DeleteMapping("/healthInsurances/{companyID}")
	public String deletePlans(@PathVariable long companyID)
	{
		
		HealthInsurance thehealthInsurance = healthInsuranceService.findById(companyID);
		
		if(thehealthInsurance == null)
		{
			throw new HealthInsuranceCompanyNotFoundException(" HealthInsurance company of ID is not present " +companyID);
		}
		
		healthInsuranceService.deleteById(companyID);
		
		return "HealthInsurance company  deleted of Id- " +companyID;
	}
	
	
	
	

}
