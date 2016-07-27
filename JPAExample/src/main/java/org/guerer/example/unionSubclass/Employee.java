package org.guerer.example.unionSubclass;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Employee extends Person {

	@Column(name = "TITLE")
	private String title;

	@OneToMany(targetEntity = Customer.class, mappedBy = "employee")
	private Set<Customer> customers;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MANAGER_ID")
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
