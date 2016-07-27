package org.guerer.example.secondary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "PERSON")
@SecondaryTable(name = "PERSON_DETAIL", pkJoinColumns = @PrimaryKeyJoinColumn(
		name = "PERSON_ID"))
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PERSON_ID")
	private Integer id;

	@Column(name = "AGE")
	private Integer age;

	@Transient
	private String content;

	@Column(name = "EMAIL", table = "PERSON_DETAIL")
	private String email;

	@Column(name = "PHONE", table = "PERSON_DETAIL")
	private String phone;

	public Person() {
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", age=" + age + ", content=" + content
				+ ", email=" + email + ", phone=" + phone + "]";
	}

}
