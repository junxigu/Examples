package org.guerer.example.mapKeyCompAttr;

import java.util.Map;

public class Person {

	private Integer id;
	private Integer age;
	private Map<Name, Integer> nicks;

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

	public Map<Name, Integer> getNicks() {
		return nicks;
	}

	public void setNicks(Map<Name, Integer> nicks) {
		this.nicks = nicks;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", age=" + age + ", nicks=" + nicks + "]";
	}

}
