package org.guerer.example.bidirecOneToNMapAtti;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer age;

	@OneToMany(cascade = CascadeType.ALL, targetEntity = Address.class,
			mappedBy = "person")
	@MapKey(name = "id")
	private Map<AddressPK, Address> addresses;

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

	public Map<AddressPK, Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Map<AddressPK, Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", age=" + age + ", addresses=" + addresses
				+ "]";
	}

}
