package org.guerer.example.unionSubclass;

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
