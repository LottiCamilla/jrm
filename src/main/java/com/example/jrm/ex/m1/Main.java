package com.example.jrm.ex.m1;

import java.util.List;

import com.example.jrm.ex.m1.dao.DaoEmployee;
import com.example.jrm.dao.Employee;

public class Main {
	private DaoEmployee dao;
	
	public Main() {
		dao = new DaoEmployee();
	}
	
	public void printOrdered() {
		List<Employee> employees = dao.getOrderedByLastName();
		System.out.println("\n\nTutti i dipendenti, ordinati per cognome e nome");
		employees.forEach(System.out::println);
	}
	
	public void printIfNameIs(String name) {
		List<Employee> employees = dao.getIfNameIs(name);
		System.out.println("\n\nChi ha nome David");
		employees.forEach(System.out::println);
	}
	
	public void printIfNameIsOr(String name1, String name2) {
		List<Employee> employees = dao.getIfNameIsOr(name1, name2);
		System.out.println("\n\nChi ha nome David o Peter");
		employees.forEach(System.out::println);
	}
	
	public void printIfDepartmenteIdIs(Integer departmentId) {
		List<Employee> employees = dao.getIfDepartmentIdIs(departmentId);
		System.out.println("\n\nChi appartiene al dipartimento 6");
		employees.forEach(System.out::println);
	}
	
	public void printIfSalryIsBetweenAndDeparmentIdIs(Double minSalary, Double maxSalary, Integer departmentId1, Integer departmentId2) {
		List<Employee> employees = dao.getIfSalryIsBetweenAndDeparmentIdIs(minSalary, maxSalary, departmentId1, departmentId2);
		System.out.println("\n\nChi ha salario minore di 4000 o maggiore di 15000, ma solo per i dipartimenti 5 e 8");
		employees.forEach(System.out::println);
	}
	
	public void printIfYearOfHiredIs(String year) {
		List<Employee> employees = dao.getIfYearOfHiredIs(year);
		System.out.println("\n\nEmployee - Chi è stato assunto nel 2015");
		employees.forEach(System.out::println);
	}
	
	public void printJobId() {
		List<Integer> jobId = dao.getJobId();
		System.out.println("\n\nEmployee - Quali job_id sono presenti, in ordine naturale");
		jobId.forEach(System.out::println);
	}
	
	public void printIfHasACommision() {
		List<Employee> employees = dao.getIfHasACommision();
		System.out.println("\n\nEmployee - Chi ha una commissione");
		employees.forEach(System.out::println);
	}
	
	public void printIfContainsPattern(String string) {
		List<Employee> employees = dao.getIfContainsPattern(string);
		System.out.println("\n\nChi ha una ‘a’ nel nome o cognome");
		employees.forEach(System.out::println);
	}
	
	public void printName() {
		List<String> name = dao.getName();
		System.out.println("\n\nDepartment - Nomi, in ordine naturale");
		name.forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.printOrdered();
		main.printIfNameIs("David");
		main.printIfNameIsOr("David", "Peter");
		main.printIfDepartmenteIdIs(6);
		main.printIfSalryIsBetweenAndDeparmentIdIs(4000.0, 15000.0, 5, 8);
		main.printIfYearOfHiredIs("2015");
		main.printJobId();
		main.printIfHasACommision();
		main.printIfContainsPattern("%a%");
		main.printName();
	}

}
