package com.example.jrm.ex.m1;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Department {
	
	@Id
	@Column(name="DEPARTMENT_ID")
	private Integer id;
	
	private String name;
	
	@Column(name="MANAGER_ID")
	private Integer managerId;
	
	@Column(name="LOCATION_ID")
	private Integer locationId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", managerId=" + managerId + ", locationId=" + locationId
				+ "]";
	}

}
