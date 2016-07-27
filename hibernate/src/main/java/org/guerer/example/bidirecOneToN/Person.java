package org.guerer.example.bidirecOneToN;

import java.util.Set;

public class Person {

	private Integer id;
	private Integer age;
	private Set<Address> addresses;

	public Person() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", age=" + age + ", address=" + addresses
				+ "]";
	}

}
