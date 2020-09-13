package com.realesta.employeedetails;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Shireenbanu
 */
@Entity
public class Employee {

	private @Id @GeneratedValue Long id;
	private String category;
	private String description;
	private String status;
	private String assigned;

	private Employee() {}

	public Employee(String category, String description, String status, String assigned) {
		this.category = category;
		this.description = description;
		this.status = status;
		this.assigned = assigned;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Employee employee = (Employee) o;
		return Objects.equals(id, employee.id) &&
			Objects.equals(category, employee.category) &&
			Objects.equals(description, employee.description) &&
			Objects.equals(status, employee.status) &&
			Objects.equals(assigned, employee.assigned);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAssigned() {
		return assigned;
	}

	public void setAssigned(String assigned) {
		this.assigned = assigned;
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, category, description, status, assigned);
	}

	
	@Override
	public String toString() {
		return "Employee{" +
			"id=" + id +
			", category='" + category + '\'' +
			", description='" + description + '\'' +
			", status='" + status + '\'' +
			", assigned='" + assigned + '\'' +
			'}';
	}
}
