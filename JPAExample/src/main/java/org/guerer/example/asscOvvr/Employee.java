package org.guerer.example.asscOvvr;

import javax.persistence.AssociationOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
@AssociationOverride(name = "address", joinColumns = @JoinColumn(
		name = "EMPLOYEE_ADDRESS"))
public class Employee extends Person {

	@Column(name = "TITLE")
	private String title;

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

	@Override
	public String toString() {
		return "Employee [title=" + title + ", toString()=" + super.toString()
				+ "]";
	}

}
