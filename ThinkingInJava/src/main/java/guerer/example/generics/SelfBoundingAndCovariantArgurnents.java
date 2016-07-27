package guerer.example.generics;

interface SelfBoundSetter<T extends SelfBoundSetter<T>> {
	void set(T t);
}

interface Setter extends SelfBoundSetter<Setter> {

}

public class SelfBoundingAndCovariantArgurnents {

	void testA(Setter s1, Setter s2, SelfBoundSetter<Setter> sb1) {
		s1.set(s2);
		// s1.set(sb1);
	}

	public static void main(String[] args) {
	}

}
