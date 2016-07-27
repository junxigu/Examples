package guerer.example.util;

public class TwoTuple<A, B> {

	public final A first;
	public final B second;

	public TwoTuple(A first, B second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public String toString() {
		return "(" + first + ", " + second + ")";
	}
	
	@Override
	public boolean equals(Object tuple) {
		@SuppressWarnings("unchecked")
		boolean result = tuple instanceof TwoTuple && ((TwoTuple<A, B>) tuple).first.equals(first)
				&& ((TwoTuple<A, B>) tuple).second.equals(second);
		return result;
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result += result * 37 + first.hashCode();
		result += result * 37 + second.hashCode();
		return result;
	}

}
