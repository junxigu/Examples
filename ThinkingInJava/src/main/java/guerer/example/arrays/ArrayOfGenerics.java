package guerer.example.arrays;

import java.util.ArrayList;
import java.util.List;

class BerylliumSphere {

}

public class ArrayOfGenerics {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		List<String>[] ls;
		List[] la = new List[10];
		ls = (List<String>[]) la; // "Unchecked" warning
		ls[0] = new ArrayList<String>();
		// Compile-time checking produces an error:
		// ! ls[l] = new ArrayList<Integer>();
		// The problem: List<String> is a subtype of Object
		Object[] objects = ls; // So assignment is OK
		// Compiles and runs without complaint:
		objects[1] = new ArrayList<Integer>();
		// However, if your needs are straight forward it is
		// possible to create an array of generics, able it
		// with an "unchecked" warning:
		List<BerylliumSphere>[] spheres = (List<BerylliumSphere>[]) new List[10];
		for (int i = 8; i < spheres.length; i++)
			spheres[i] = new ArrayList<BerylliumSphere>();
	}
}
