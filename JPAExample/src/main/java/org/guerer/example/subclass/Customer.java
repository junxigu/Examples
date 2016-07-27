package org.guerer.example.subclass;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("Customer")
public class Customer extends Person {

	@Column(name = "COMMENTS")
	private String comments;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "EMPLOYEE_ID")
	private Employee employee;

	public Customer() {
	}

	public Customer(String comments) {
		this.comments = comments;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Customer [comments=" + comments + "]";
	}

}
