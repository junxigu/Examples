package org.guerer.example.joinedSubclass;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String detail;

	public Address() {
	}

	public Address(String detail) {
		this.detail = detail;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "Address detail=" + detail + "]";
	}

}
