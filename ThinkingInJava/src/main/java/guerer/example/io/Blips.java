package guerer.example.io;

import guerer.example.util.Print;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class Blip1 implements Externalizable {
	public Blip1() {
		Print.print("Blip1 Constructor ");
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		Print.print("Blip1.writeExternal");
	}

	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		Print.print("Blip1.readExternal");
	}
}

class Blip2 implements Externalizable {
	Blip2() {
		Print.print("Blip2 Constructor");
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		Print.print("Blip2.writeExternal");
	}

	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		Print.print("Blip2.readExternal");
	}
}

public class Blips {

	public static void main(String[] args) throws ClassNotFoundException,
			IOException {
		Print.print("Constructing objects: ");
		Blip1 b1 = new Blip1();
		Blip2 b2 = new Blip2();
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(
				"Blips.out"));
		Print.print("Saving objects: ");
		o.writeObject(b1);
		o.writeObject(b2);
		o.close();

		// Now get them back:
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				"Blips.out"));
		Print.print("Recovering bl:");
		b1 = (Blip1) in.readObject();
		// OOPS! Throws an exception:
		// ! Print.print("Recovering b2:");
		// ! b2 = (Blip2)in.readObject();
		in.close();
	}

}
