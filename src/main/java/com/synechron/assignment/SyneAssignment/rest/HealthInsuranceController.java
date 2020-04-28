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
	public String savePlans(@RequestBody Policy thePolicy)
	{
		//thePolicy.setPolicyId(0);
		
		healthInsuranceService.save(thePolicy);
		
		return "Health Insurance Plan added successfully";
	}
	
	//get all companies
	@GetMapping
	public List<Policy> getAllPlans() throws ObjectNotFoundException
	{
		List<Policy> thePolicy = healthInsuranceService.findAll();
		
		if(thePolicy.size() == 0)
		{
			throw new ObjectNotFoundException("No Plans exists");
		}
		return thePolicy;
		
	}
	
	//getbypolicyTypeAndAge
		@GetMapping("/{planType}/{ageGroup}")
		public List<Policy> getUsingPolicyTypeandAge(@PathVariable String planType, @PathVariable String ageGroup) throws ObjectNotFoundException
		{
			
			
			//to check active policy
			List<Policy> policy = healthInsuranceService.findByPlanTypeAndAgeGroupAndIsActive(planType,ageGroup,true);
			
			if(policy == null)
			{
				
			throw new ObjectNotFoundException(" No active policy for Company ");
			}
			
			return policy;
			
		}
	
	
	//getbypolicyTypeAndageAndCover
	@GetMapping("/{planType}/{ageGroup}/{cover}")
	public Policy getPolicyTypeAgeCover(@PathVariable String planType, @PathVariable String ageGroup, @PathVariable Long cover) throws ObjectNotFoundException
	{
		
		
		//to check active policy
		Policy policy = healthInsuranceService.findByPlanTypeAndAgeGroupAndCoverAndIsActive(planType,ageGroup,cover,true);
		
		if(policy == null)
		{
			
		throw new ObjectNotFoundException(" No active policy for Company ");
		}
		
		return policy;
		
	}
	
	//to get all the policies that are active by companyID
	@GetMapping("/{companyID}")
	public List<Policy> getPlansByID(@PathVariable long companyID) throws ObjectNotFoundException
	{
		
		Policy thePolicy = healthInsuranceService.findById(companyID);
		
		if(thePolicy == null)
		{
			throw new ObjectNotFoundException(" HealthInsurance company of ID is not present " +companyID);
		}
		
		//to check active policy
		List<Policy> policy = healthInsuranceService.findByHealthInsuranceAndIsActive(thePolicy,true);
		
		if(policy.size() == 0)
		{
			
		throw new ObjectNotFoundException(" No active policy for Company " +thePolicy.getPolicyName());
		}
		
		return policy;
		
	}
	
	@GetMapping("/{companyName}")
	public List<Policy> getPlansByID(@PathVariable String companyName) throws ObjectNotFoundException
	{
		
		Policy thePolicy = healthInsuranceService.findByCompanyName(companyName);
		
		if(thePolicy == null)
		{
			throw new ObjectNotFoundException(" HealthInsurance company of ID is not present " +companyName);
		}
		
		//to check active policy
		List<Policy> policy = healthInsuranceService.findByHealthInsuranceAndIsActive(thePolicy,true);
		
		if(policy.size() == 0)
		{
			
		throw new ObjectNotFoundException(" No active policy for Company " +thePolicy.getPolicyName());
		}
		
		return policy;
		
	}
	
	
		
	//to update company
	@PutMapping
	public Policy updatePlans(@RequestBody Policy thehealthInsurance)
	{
		healthInsuranceService.save(thehealthInsurance);
		
		return thehealthInsurance;
	}
	
	//to delete company
	@DeleteMapping("/{companyID}")
	public String deletePlans(@PathVariable long companyID) throws ObjectNotFoundException
	{
		
		Policy thePolicy = healthInsuranceService.findById(companyID);
		
		if(thePolicy == null)
		{
			throw new ObjectNotFoundException(" HealthInsurance company of ID is not present " +companyID);
		}
		
		healthInsuranceService.deleteById(companyID);
		
		return "HealthInsurance company  deleted of Id- " +companyID;
	}
	
	
	
	

}
