package org.guerer.example.unionSubclass;

import java.util.Set;

public class Manager extends Employee {

	private String department;
	private Set<Employee> employees;

	public Manager() {
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Manager [department=" + department + ", employees=" + employees + "]";
	}

}
