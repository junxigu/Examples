package org.guerer.example.entityLife;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PERSON_ID")
	private Integer id;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PASSWORD")
	private String password;

	public Person() {
	}

	public Person(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", email=" + email + ", password="
				+ password + "]";
	}

	@PrePersist
	public void prePersist() {
		System.out.println("prePersist");
		reverse();
	}

	@PostPersist
	public void postPersist() {
		System.out.println("postPersist");
		reverse();
	}

	@PreUpdate
	public void preUpdate() {
		System.out.println("preUpdate");
		reverse();
	}

	@PostUpdate
	public void postUpdate() {
		System.out.println("postUpdate");
		reverse();
	}

	@PostLoad
	public void postLoad() {
		System.out.println("postLoad");
		reverse();
	}

	private void reverse() {
		password = new StringBuilder(password).reverse().toString();
	}
}
