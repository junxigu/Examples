package org.guerer.example.compMapAttr;

import java.util.Map;

public class Name {

	private String first;
	private String last;
	private Person owner;
	private Map<String, Integer> power;

	public Name() {
	}

	public Name(String first, String last, Map<String, Integer> power) {
		this.first = first;
		this.last = last;
		this.power = power;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	public Map<String, Integer> getPower() {
		return power;
	}

	public void setPower(Map<String, Integer> power) {
		this.power = power;
	}

	@Override
	public String toString() {
		return "Name [first=" + first + ", last=" + last + ", power=" + power
				+ "]";
	}

}
