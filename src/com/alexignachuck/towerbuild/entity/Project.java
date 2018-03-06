package com.alexignachuck.towerbuild.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="project")
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="project_number")
	private int projectNumber;
	
	@Column(name="carrier_name")
	private String carrierName;
	
	@Column(name="contract_number")
	private int contractNumber;
	
	@Column(name="contact_company")
	private String contactCompany;
	
	@Column(name="contact_first_name")
	private String contactFirstName;
	
	@Column(name="contact_last_name")
	private String contactLastName;
	
	@Column(name="contact_email")
	private String contactEmail;
	
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, 
						 CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="tower_reference_id")
	private Tower tower;
	
	public Project() {
		
	}

	public Project(String carrierName, int contractNumber, String contactCompany, String contactFirstName,
			String contactLastName, String contactEmail) {
		super();
		this.carrierName = carrierName;
		this.contractNumber = contractNumber;
		this.contactCompany = contactCompany;
		this.contactFirstName = contactFirstName;
		this.contactLastName = contactLastName;
		this.contactEmail = contactEmail;
	}

	public int getProjectNumber() {
		return projectNumber;
	}

	public void setProjectNumber(int projectNumber) {
		this.projectNumber = projectNumber;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public int getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(int contractNumber) {
		this.contractNumber = contractNumber;
	}

	public String getContactCompany() {
		return contactCompany;
	}

	public void setContactCompany(String contactCompany) {
		this.contactCompany = contactCompany;
	}

	public String getContactFirstName() {
		return contactFirstName;
	}

	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}

	public String getContactLastName() {
		return contactLastName;
	}

	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public Tower getTower() {
		return tower;
	}

	public void setTower(Tower tower) {
		this.tower = tower;
	}

	@Override
	public String toString() {
		return "Project [projectNumber=" + projectNumber + ", carrierName=" + carrierName + ", contractNumber="
				+ contractNumber + ", contactCompany=" + contactCompany + ", contactFirstName=" + contactFirstName
				+ ", contactLastName=" + contactLastName + ", contactEmail=" + contactEmail + "]";
	}

	
	
	
	
	

}
