package com.synechron.assignment.SyneAssignment.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table
public class Policy {
	
	
	@Id
	private long policyNum;
	
	@Column
	private String policyType;
	
	@Column
	private long cover;
	
	@Column
	private float numOfYears;
	
	@Column
	private double premiumMonthly;
	
	@Column
	private double premiumYearly;
	
	@JsonBackReference
	@ManyToOne 
	@JoinColumn(name="companyId")
	private HealthInsurance healthInsurance;
	
	
	
	public Policy()
	{
		
	}

	
	

	public Policy(long policyNum, String policyType, long cover, float numOfYears, double premiumMonthly,
			double premiumYearly, HealthInsurance healthInsurance) {
		super();
		this.policyNum = policyNum;
		this.policyType = policyType;
		this.cover = cover;
		this.numOfYears = numOfYears;
		this.premiumMonthly = premiumMonthly;
		this.premiumYearly = premiumYearly;
		this.healthInsurance = healthInsurance;
	}




	public long getPolicyNum() {
		return policyNum;
	}

	public void setPolicyNum(long policyNum) {
		this.policyNum = policyNum;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
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

	public HealthInsurance getHealthInsurance() {
		return healthInsurance;
	}

	public void setHealthInsurance(HealthInsurance healthInsurance) {
		this.healthInsurance = healthInsurance;
	}

	@Override
	public String toString() {
		return "Policy [policyNum=" + policyNum + ", policyType=" + policyType + ", cover=" + cover + ", numOfYears="
				+ numOfYears + ", premiumMonthly=" + premiumMonthly + ", premiumYearly=" + premiumYearly
				+ ", healthInsurance= ]";
	}

	

	
}
