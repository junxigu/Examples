package org.guerer.example.oneToOnePriKey;

public class Address {

	private Integer id;
	private String detail;

	public Address() {
	}

	public Address(String detail) {
		this.detail = detail;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", detail=" + detail + "]";
	}

}
