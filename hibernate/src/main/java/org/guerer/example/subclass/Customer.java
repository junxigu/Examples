package org.guerer.example.subclass;

public class Customer extends Person {

	private String comments;
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
