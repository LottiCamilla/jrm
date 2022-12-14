package com.example.jrm.ex.m2;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "DEPARTMENT")
public class DepartmentOneToMany {

	@Id
	@Column(name = "DEPARTMENT_ID")
	private Integer id;

	private String name;

	@ManyToOne
	@JoinColumn(name = "MANAGER_ID")
	private Employee manager;

	@Column(name = "LOCATION_ID")
	private Integer locationId;

	@OneToMany(mappedBy = "department", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Employee> employees = new HashSet<>();

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

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "DepartmentOneToMany [id=" + id + ", name=" + name + 
				(manager != null ? ", manager=" + manager.getFirstName() + " " + manager.getLastName(): "") + 
				(employees != null ? ", employees=" + employees: "") +  
				"]";
	}
}
