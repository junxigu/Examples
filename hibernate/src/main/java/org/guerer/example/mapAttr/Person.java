package org.guerer.example.mapAttr;

import java.util.Map;

public class Person {

	private Integer id;
	private String name;
	private Integer age;
	private Map<String, Float> scores;

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

	public Map<String, Float> getScores() {
		return scores;
	}

	public void setScores(Map<String, Float> scores) {
		this.scores = scores;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age
				+ ", scores=" + scores + "]";
	}

}
