package guerer.example.typeinfos.pets;

public class Individual implements Comparable<Individual> {

	private static long counter;
	private final long id = counter++;
	private String name = null;

	public Individual(String name) {
		this.name = name;
	}

	public Individual() {
	}

	public long id() {
		return id;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + (name == null ? "" : name);
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof Individual && id == ((Individual) o).id;
	}

	@Override
	public int hashCode() {
		int result = 17;
		if (name != null) {
			result = result * 37 + name.hashCode();
		}
		return result * 37 + (int) id;
	}

	public int compareTo(Individual o) {
		int result = getClass().getSimpleName().compareTo(
				o.getClass().getSimpleName());
		if (result != 0) {
			return result;
		}
		if (name != null && o.name != null) {
			result = name.compareTo(o.name);
			if (result != 0) {
				return result;
			}
		}
		return id < o.id ? -1 : (id == o.id ? 0 : 1);
	}

}
