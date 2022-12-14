package com.example.jrm.ex.m2;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name = "ex.Employee")
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	@Column(name = "EMPLOYEE_ID")
	private Integer id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	private LocalDate hired;

	private Double salary;

	@ManyToOne
	@JoinColumn(name = "JOB_ID")
	private Job job;

	private Double commission;

	@ManyToOne
	@JoinColumn(name = "DEPARTMENT_ID")
	private DepartmentOneToMany department;
	
	@ManyToOne
	@JoinColumn(name = "MANAGER_ID")
	private Employee manager;

	public Employee() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getHired() {
		return hired;
	}

	public void setHired(LocalDate hired) {
		this.hired = hired;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Double getCommission() {
		return commission;
	}

	public void setCommission(Double commision) {
		this.commission = commision;
	}

	public DepartmentOneToMany getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentOneToMany departmentId) {
		this.department = departmentId;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", hired=" + hired
				+ ", salary=" + salary +
				(job != null ? ", job=" + job.getTitle(): "") +
				", commission=" + commission + 
				(department != null ? ", department=" + department.getName(): "") + 
				(manager != null ? ", manager=" + manager.firstName + " " + manager.lastName: "") + "]";
	}
}
