package org.guerer.example.unionSubclass;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MANAGER")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Manager extends Employee {

	@Column(name = "DEPARTMENT")
	private String department;

	@OneToMany(targetEntity = Employee.class, mappedBy = "manager")
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
		return "Manager [department=" + department + ", employees=" + employees
				+ "]";
	}

}
