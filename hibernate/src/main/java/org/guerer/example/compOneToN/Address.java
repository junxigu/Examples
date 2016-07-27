package org.guerer.example.compOneToN;

import java.util.Set;

public class Address {

	private String detail;
	private Set<School> schools;
	private Person owner;

	public Address() {
	}

	public Address(String detail) {
		this.detail = detail;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Set<School> getSchools() {
		return schools;
	}

	public void setSchools(Set<School> schools) {
		this.schools = schools;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Address [detail=" + detail + ", schools="
				+ schools + "]";
	}

}
