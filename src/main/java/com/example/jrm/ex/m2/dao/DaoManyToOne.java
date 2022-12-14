package com.example.jrm.ex.m2.dao;

import java.util.List;

import com.example.jrm.dao.JpaUtil;
import com.example.jrm.ex.m2.DepartmentOneToMany;
import com.example.jrm.ex.m2.Employee;

import jakarta.persistence.EntityManager;

public class DaoManyToOne {
	
	public List<Employee> readAll(){
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

        try {
            String jpql = "SELECT e FROM ex.Employee e";
            return em.createQuery(jpql, Employee.class).getResultList();
        } finally {
            em.close();
        }
	}
	
	public List<Employee> readWhoHasSalaryMinOrMax(){
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

        try {
            String jpql = "SELECT e FROM ex.Employee e WHERE e.salary = e.job.minSalary OR e.salary = e.job.maxSalary ORDER BY e.job";
            return em.createQuery(jpql, Employee.class).getResultList();
        } finally {
            em.close();
        }
	}
	
	public List<DepartmentOneToMany> readDepAndManager(){
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

        try {
            String jpql = "SELECT d FROM DepartmentOneToMany d WHERE d.manager IS NOT NULL";
            return em.createQuery(jpql, DepartmentOneToMany.class).getResultList();
        } finally {
            em.close();
        }
	}

}
