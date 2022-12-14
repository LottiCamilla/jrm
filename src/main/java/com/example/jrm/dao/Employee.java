package com.example.jrm.dao;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

@Entity 
@NamedQuery(name = "getTopSalaried", query = "FROM Employee e WHERE e.salary >= :low ORDER BY e.salary DESC")
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
    
    @Column(name = "DEPARTMENT_ID")
    private Integer departmentId;
    
    @Column(name = "JOB_ID")
    private Integer jobId;
    
    private Double commission;

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

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public Double getCommission() {
		return commission;
	}

	public void setCommission(Double commision) {
		this.commission = commision;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", hired=" + hired
				+ ", salary=" + salary + ", departmentId=" + departmentId + ", jobId=" + jobId + ", commission="
				+ commission + "]";
	}
}
