package org.guerer.example.bidirecOneToNMapAtti;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class AddressPK implements Serializable {

	private static final long serialVersionUID = -2169648524442115497L;
	private String street;
	private String detail;

	public AddressPK() {
	}

	public AddressPK(String street, String detail) {
		this.street = street;
		this.detail = detail;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "AddressPK [street=" + street + ", detail=" + detail + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((detail == null) ? 0 : detail.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressPK other = (AddressPK) obj;
		if (detail == null) {
			if (other.detail != null)
				return false;
		} else if (!detail.equals(other.detail))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}

}
