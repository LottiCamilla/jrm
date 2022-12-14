package com.example.jrm.ex.m1.dao;

import java.util.List;

import com.example.jrm.dao.Employee;
import com.example.jrm.dao.JpaUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class DaoEmployee {
	
	public List<Employee> getOrderedByLastName(){
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			String jpql = "FROM Employee e ORDER BY e.lastName, e.firstName";
			TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
			return query.getResultList();
		} finally {
			em.close();
		}
	}
	
	public List<Employee> getIfNameIs(String name){
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			String jpql = "FROM Employee e WHERE e.firstName = :name ORDER BY e.lastName";
			TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
			query.setParameter("name", name);
			return query.getResultList();
		} finally {
			em.close();
		}
	}
	
	public List<Employee> getIfNameIsOr(String name1, String name2){
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			String jpql = "FROM Employee e WHERE e.firstName = :name1 OR e.firstName = :name2 ORDER BY e.firstName, e.lastName";
			TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
			query.setParameter("name1", name1);
			query.setParameter("name2", name2);
			return query.getResultList();
		} finally {
			em.close();
		}
	}
	
	public List<Employee> getIfDepartmentIdIs(Integer departmentId){
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			String jpql = "FROM Employee e WHERE e.departmentId = :departmentId ORDER BY e.lastName, e.firstName";
			TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
			query.setParameter("departmentId", departmentId);
			return query.getResultList();
		} finally {
			em.close();
		}
	}
	
	public List<Employee> getIfSalryIsBetweenAndDeparmentIdIs(Double minSalary, Double maxSalary, Integer departmentId1, Integer departmentId2){
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			String jpql = "FROM Employee e WHERE (e.salary < :minSalary OR e.salary > :maxSalary) AND e.departmentId IN (:departmentId1, :departmentId2) ORDER BY e.salary";
			TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
			query.setParameter("minSalary", minSalary);
			query.setParameter("maxSalary", maxSalary);
			query.setParameter("departmentId1", departmentId1);
			query.setParameter("departmentId2", departmentId2);
			return query.getResultList();
		} finally {
			em.close();
		}
	}
	
	public List<Employee> getIfYearOfHiredIs(String year){
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			String jpql = "FROM Employee e WHERE extract(year from hired) = :year ORDER BY e.hired";
			TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
			query.setParameter("year", year);
			return query.getResultList();
		} finally {
			em.close();
		}
	}
	
	public List<Integer> getJobId(){
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			String jpql = "SELECT DISTINCT e.jobId FROM Employee e ORDER BY e.jobId";
			TypedQuery<Integer> query = em.createQuery(jpql, Integer.class);
			return query.getResultList();
		} finally {
			em.close();
		}
	}
	
	public List<Employee> getIfHasACommision(){
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			String jpql = "FROM Employee e WHERE e.commission IS NOT NULL ORDER BY e.commission DESC, e.firstName";
			TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
			return query.getResultList();
		} finally {
			em.close();
		}
	}
	
	public List<Employee> getIfContainsPattern(String string){
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			String jpql = "FROM Employee e WHERE e.firstName ILIKE :string OR e.lastName ILIKE :string ORDER BY e.lastName, e.firstName";
			TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
			query.setParameter("string", string);
			return query.getResultList();
		} finally {
			em.close();
		}
	}
	
	public List<String> getName(){
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			String jpql = "SELECT d.name FROM Department d ORDER BY d.name";
			TypedQuery<String> query = em.createQuery(jpql, String.class);
			return query.getResultList();
		} finally {
			em.close();
		}
	}

}
