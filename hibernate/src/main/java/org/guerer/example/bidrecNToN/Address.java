package org.guerer.example.bidrecNToN;

import java.util.Set;

public class Address {

	private Integer id;
	private String detail;
	private Set<Person> persons;

	public Address() {
	}

	public Address(String detail) {
		this.detail = detail;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Set<Person> getPersons() {
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", detail=" + detail + "]";
	}

}
