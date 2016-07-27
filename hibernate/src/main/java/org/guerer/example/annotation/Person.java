package org.guerer.example.annotation;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
public class Person {

	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "first", column = @Column(name = "FIRST") ),
			@AttributeOverride(name = "last", column = @Column(name = "LAST") ) })
	private Name name;

	@Column(name = "AGE")
	private Integer age;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "name", column = @Column(name = "NAME") ),
			@AttributeOverride(name = "color", column = @Column(name = "COLOR") ), })
	private Cat cat;

	public Person() {
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Cat getCat() {
		return cat;
	}

	public void setCat(Cat cat) {
		this.cat = cat;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", cat=" + cat + "]";
	}

}
