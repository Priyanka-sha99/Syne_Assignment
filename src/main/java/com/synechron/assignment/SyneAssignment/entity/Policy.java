package com.synechron.assignment.SyneAssignment.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table
@JsonIgnoreProperties("")
public class Policy {
	
	
	/*@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long policyId;*/
	
	@Id
	private long policyNum;
	
	@Column
	private String companyName;
	
	@Column
	private String policyName;
	
	@Column
	private long cover;
	
	@Column
	private float numOfYears;
	
	@Column
	private double premiumMonthly;
	
	@Column
	private double premiumYearly;
	
	//to get policy by age
	@Column
	private String ageGroup;
	
	@Column
	private String planType;
	
	
	@Column
	@JsonProperty(access = Access.WRITE_ONLY)
	private boolean isActive = true;
	
	/*@JsonBackReference
	@ManyToOne 
	@JoinColumn(name="companyId")
	private HealthInsurance healthInsurance;*/
	
	
	
	public Policy()
	{
		
	}
	
	
	
	

    public Policy(long policyNum, String policyName, long cover, float numOfYears, double premiumMonthly,
			double premiumYearly, String age, boolean isActive) {
		super();
		this.policyNum = policyNum;
		this.policyName = policyName;
		this.cover = cover;
		this.numOfYears = numOfYears;
		this.premiumMonthly = premiumMonthly;
		this.premiumYearly = premiumYearly;
		//this.age = age;
		this.isActive = isActive;
	}


    public String getCompanyName() {
		return companyName;
	}

    public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


    public long getPolicyNum() {
		return policyNum;
	}

	public void setPolicyNum(long policyNum) {
		this.policyNum = policyNum;
	}

	public String getPolicyName() {
		return policyName;
	}

	

	public long getCover() {
		return cover;
	}

	public void setCover(long cover) {
		this.cover = cover;
	}

	public float getNumOfYears() {
		return numOfYears;
	}

	public void setNumOfYears(float numOfYears) {
		this.numOfYears = numOfYears;
	}

	public double getPremiumMonthly() {
		return premiumMonthly;
	}

	public void setPremiumMonthly(double premiumMonthly) {
		this.premiumMonthly = premiumMonthly;
	}

	public double getPremiumYearly() {
		return premiumYearly;
	}

	public void setPremiumYearly(double premiumYearly) {
		this.premiumYearly = premiumYearly;
	}






	public String getAgeGroup() {
		return ageGroup;
	}





	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}





	public String getPlanType() {
		return planType;
	}





	public void setPlanType(String planType) {
		this.planType = planType;
	}





	@JsonIgnore
	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Policy [policyNum=" + policyNum + ", policyType=" + policyName + ", cover=" + cover + ", numOfYears="
				+ numOfYears + ", premiumMonthly=" + premiumMonthly + ", premiumYearly=" + premiumYearly
				+ ", healthInsurance= ]";
	}

	

	
}
