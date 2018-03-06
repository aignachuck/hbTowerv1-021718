package com.alexignachuck.towerbuild.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tower_detail")
public class Tower {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tower_reference_id")
	private int towerId;
	
	@Column(name="tower_number")
	private int towerNumber;
	
	@Column(name="tower_name")
	private String towerName;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@OneToMany(mappedBy="tower",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
					     CascadeType.DETACH, CascadeType.REFRESH})
	private List<Project> projects;
	
	public Tower() {
		
	}


	public Tower(int towerNumber, String towerName, String city, String state) {
		super();
		this.towerNumber = towerNumber;
		this.towerName = towerName;
		this.city = city;
		this.state = state;
	}


	public int getTowerNumber() {
		return towerNumber;
	}


	public void setTowerNumber(int towerNumber) {
		this.towerNumber = towerNumber;
	}


	public String getTowerName() {
		return towerName;
	}


	public void setTowerName(String towerName) {
		this.towerName = towerName;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	@Override
	public String toString() {
		return "Tower [towerId=" + towerId + ", towerNumber=" + towerNumber + ", towerName=" + towerName + ", city="
				+ city + ", state=" + state + "]";
	}


	public List<Project> getProjects() {
		return projects;
	}


	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	public void add(Project tempProject) {
		
		if(projects == null) {
			projects = new ArrayList<>();
		}
		
		projects.add(tempProject);
		
		tempProject.setTower(this);
	}
	
	
	

}
