package org.guerer.example.abstractEntity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("Employee")
public class Employee extends Person {

	@Column(name = "TITLE")
	private String title;

	@OneToMany(targetEntity = Customer.class, mappedBy = "employee")
	private Set<Customer> customers;

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

	@Override
	public String toString() {
		return "Employee [title=" + title + ", customers=" + customers
				+ ", toString()=" + super.toString() + "]";
	}

}
