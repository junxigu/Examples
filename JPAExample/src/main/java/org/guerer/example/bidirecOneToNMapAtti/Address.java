package org.guerer.example.bidirecOneToNMapAtti;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class Address {

	@EmbeddedId
	@AttributeOverrides(value = {
			@AttributeOverride(column = @Column(name = "STREET"),
					name = "street"),
			@AttributeOverride(column = @Column(name = "DETAIL"),
					name = "detail") })
	private AddressPK id;

	@ManyToOne
	@JoinColumn(name = "PERSON_ID")
	private Person person;

	public Address() {
	}

	public Address(AddressPK id) {
		this.id = id;
	}

	public AddressPK getId() {
		return id;
	}

	public void setId(AddressPK id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + "]";
	}

}
