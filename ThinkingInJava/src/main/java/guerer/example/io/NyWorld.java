package guerer.example.io;

import guerer.example.util.Print;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NyWorld {
	static class House implements Serializable {
		// private static final long serialVersionUID = 1222771015245546274L;
	}

	static class Animal implements Serializable {
		// private static final long serialVersionUID = 3763753077850529387L;
		private String name;
		private House preferredHouse;

		Animal(String nm, House h) {
			name = nm;
			preferredHouse = h;
		}

		public String toString() {
			return name + "[" + super.toString() + "], " + preferredHouse
					+ "\n";
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		House house = new House();
		List<Animal> animals = new ArrayList<Animal>();
		animals.add(new Animal("Bosco the dog", house));
		animals.add(new Animal("Ra1ph the hamster", house));
		animals.add(new Animal("Mo1ly the cat", house));
		Print.print("anima1s: " + animals);
		ByteArrayOutputStream buf1 = new ByteArrayOutputStream();
		ObjectOutputStream o1 = new ObjectOutputStream(buf1);
		o1.writeObject(animals);
		o1.writeObject(animals); // Write a 2nd set
		o1.close();

		// Write to a different stream:
		ByteArrayOutputStream buf2 = new ByteArrayOutputStream();
		ObjectOutputStream o2 = new ObjectOutputStream(buf2);
		o2.writeObject(animals);
		o2.close();

		// NOW get them back:
		ObjectInputStream in1 = new ObjectInputStream(new ByteArrayInputStream(
				buf1.toByteArray()));
		ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(
				buf2.toByteArray()));
		List animalsl = (List) in1.readObject();
		List animals2 = (List) in1.readObject();
		List animals3 = (List) in2.readObject();
		Print.print("animals1: " + animalsl);
		Print.print("animals2: " + animals2);
		Print.print("animals3: " + animals3);
	}
}
