package com.realesta.employeedetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Shireenbanu
 */
@Component
public class DatabaseLoader implements CommandLineRunner {

	private final EmployeeRepository repository;

	@Autowired
	public DatabaseLoader(EmployeeRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... strings) throws Exception {
	this.repository.save(new Employee("AC", "AC not working", "Waiting for spare parts","Alex"));
		
		this.repository.save(new Employee("Fire extinguisher", "Refill", "Scheduled","Jhon"));
		
		this.repository.save(new Employee("Facad Cleaning", "Half yearly cleaning", "Inprogress","Anil"));
	}
}
