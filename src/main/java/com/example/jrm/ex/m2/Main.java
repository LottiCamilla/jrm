package com.example.jrm.ex.m2;

import java.util.List;

import com.example.jrm.dao.JpaUtil;
import com.example.jrm.ex.m2.dao.DaoManyToOne;

public class Main {
	private DaoManyToOne daoManyToOne;
	
	public Main() {
		this.daoManyToOne = new DaoManyToOne();
	}
	
	public void printAllEmployees() {
		List<Employee> employees = daoManyToOne.readAll();
		System.out.println("\n\nNome dei dipendenti, dei loro dipartimenti, del job title e del loro manager");
		employees.forEach(System.out::println);
	}
	
	public void print() {
		List<Employee> employees = daoManyToOne.readWhoHasSalaryMinOrMax();
		System.out.println("\n\nNome dei dipendenti che hanno il salario minimo o massimo per il loro job title");
		employees.forEach(System.out::println);
	}
	
	public void printDepAndManager() {
		List<DepartmentOneToMany> employees = daoManyToOne.readDepAndManager();
		System.out.println("\n\nNome dei dipartimenti e del manager associato");
		employees.forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		
		main.printAllEmployees();
		main.print();
		main.printDepAndManager();
		
		JpaUtil.getEntityManagerFactory().close();
	}

}
