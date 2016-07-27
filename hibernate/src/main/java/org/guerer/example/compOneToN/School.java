package org.guerer.example.compOneToN;

public class School {

	private Integer id;

	public School() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "School [id=" + id + "]";
	}

}
