package org.guerer.example.entityLifeListner;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class PersonLiftListner {

	@PrePersist
	public void prePersist(Object person) {
		System.out.println("prePersist");
		((Person) person).reverse();
	}

	@PostPersist
	public void postPersist(Object person) {
		System.out.println("postPersist");
		((Person) person).reverse();
	}

	@PreUpdate
	public void preUpdate(Object person) {
		System.out.println("preUpdate");
		((Person) person).reverse();
	}

	@PostUpdate
	public void postUpdate(Object person) {
		System.out.println("postUpdate");
		((Person) person).reverse();
	}

	@PostLoad
	public void postLoad(Object person) {
		System.out.println("postLoad");
		((Person) person).reverse();
	}

}
