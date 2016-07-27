package org.guerer.example.joinedSubclass;

import java.util.Set;

public class Employee extends Person {

	private String title;
	private Set<Customer> customers;
	private Manager manager;

	public Employee() {
	}

	public Employee(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Employee [title=" + title + ", customers=" + customers + "]";
	}

}
