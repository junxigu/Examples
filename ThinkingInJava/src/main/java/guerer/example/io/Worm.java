package guerer.example.io;

import guerer.example.util.Print;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

class Data implements Serializable {
	private static final long serialVersionUID = -6836046732380501172L;
	private int n;

	public Data(int n) {
		this.n = n;
	}

	public String toString() {
		return Integer.toString(n);
	}
}

public class Worm implements Serializable {
	private static final long serialVersionUID = -4036288674689089581L;
	private static Random rand = new Random(47);
	private Data[] d = { new Data(rand.nextInt(10)),
			new Data(rand.nextInt(10)), new Data(rand.nextInt(10)) };
	private Worm next;
	private char c;

	// Value of i == number of segments
	public Worm(int i, char x) {
		Print.print("Worm constructor: " + i);
		c = x;
		if (--i > 0)
			next = new Worm(i, (char) (x + 1));
	}

	public Worm() {
		Print.print("Default constructor");
	}

	public String toString() {
		StringBuilder result = new StringBuilder(":");
		result.append(c);
		result.append("(");
		for (Data dat : d)
			result.append(dat);
		result.append(")");
		if (next != null)
			result.append(next);
		return result.toString();
	}

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		Worm w = new Worm(6, 'a');
		Print.print("w = " + w);

		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
				"Worm.out"));
		out.writeObject("Worm storage\n");
		out.writeObject(w);
		out.close();

		ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				"Worm.out"));
		Print.print((String) in.readObject());
		Print.print("w2 = " + (Worm) in.readObject());

		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		out = new ObjectOutputStream(bout);
		out.writeObject("Worm storage\n");
		out.writeObject(w);
		out.flush();

		in = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
		Print.print((String) in.readObject());
		Print.print("w3 = " + (Worm) in.readObject());
	}
}
