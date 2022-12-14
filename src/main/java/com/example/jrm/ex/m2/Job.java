package com.example.jrm.ex.m2;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name = "ex.Job")
@Table(name = "JOB")
public class Job {
	@Id
	@Column(name = "JOB_ID")
	private Integer jobId;
	
	private String title;
	
	@Column(name = "MIN_SALARY")
	private Integer minSalary;
	
	@Column(name = "MAX_SALARY")
	private Integer maxSalary;
	
	@OneToMany(mappedBy = "job")
	private Set<Employee> employees;
	
	public Job() {
	}

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(Integer minSalary) {
		this.minSalary = minSalary;
	}

	public Integer getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(Integer maxSalary) {
		this.maxSalary = maxSalary;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", title=" + title + ", minSalary=" + minSalary + ", maxSalary=" + maxSalary
				+ ", employees=" + employees + "]";
	}	

}
