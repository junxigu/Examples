package guerer.example.generics;

import guerer.example.typeinfos.pets.Cat;
import guerer.example.typeinfos.pets.Dog;
import guerer.example.typeinfos.pets.Pet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckedList {

	static void oldStyleMethod(List probablyDogs) {
		probablyDogs.add(new Cat());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Dog> dogs1 = new ArrayList<Dog>();
		oldStyleMethod(dogs1); // Quietly accepts a Cat
		List<Dog> dogs2 = Collections.checkedList(new ArrayList<Dog>(),
				Dog.class);
		try {
			oldStyleMethod(dogs2); // Throws an exception
		} catch (Exception e) {
			System.out.println(e);
		}
		// Derived types work fine:
		List<Pet> pets = Collections.checkedList(new ArrayList<Pet>(),
				Pet.class);
		pets.add(new Dog());
		pets.add(new Cat());
	}
}
