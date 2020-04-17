package com.synechron.assignment.SyneAssignment.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import javax.persistence.Table;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table
public class HealthInsurance {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long companyId;
	
	@Column
	private String companyName;
	
	@JsonManagedReference
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="companyId", referencedColumnName="companyId")
	private List<Policy> policy;
	
	
	
	public HealthInsurance() {
		
	}
	
	
	
	public HealthInsurance(long companyId, String companyName, List<Policy> policy) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.policy = policy;
	}



	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}



	public List<Policy> getPolicy() {
		return policy;
	}



	public void setPolicy(List<Policy> policy) {
		this.policy = policy;
	}



	@Override
	public String toString() {
		return "HealthInsurance [companyId=" + companyId + ", companyName=" + companyName + ", policy=" + policy + "]";
	}
	
	

	

	
	
	

}
