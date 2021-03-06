package org.guerer.example.collAttr;

import java.util.Collection;
import java.util.Set;

public class Person {

	private Integer id;
	private String name;
	private Integer age;
	private Collection<String> schools;

	public Person() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Collection<String> getSchools() {
		return schools;
	}

	public void setSchools(Collection<String> schools) {
		this.schools = schools;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", schools=" + schools + "]";
	}

}
