package org.guerer.example.nToN;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer age;

	@ManyToMany(cascade = CascadeType.ALL, targetEntity = Address.class)
	@JoinTable(name = "PERSON_ADDRESS", joinColumns = @JoinColumn(
			name = "PERSON_ID"), inverseJoinColumns = @JoinColumn(
			name = "ADDRESS_ID"))
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
		return "Person [id=" + id + ", age=" + age + ", addresses=" + addresses
				+ "]";
	}

}
