package guerer.example.io;

import guerer.example.util.Print;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Logon implements Serializable {
	private static final long serialVersionUID = 6646528124912306519L;
	private Date date = new Date();
	private String username;
	private transient String password;

	public Logon(String name, String pwd) {
		username = name;
		password = pwd;
	}

	public String toString() {
		return "logon info : \n username: " + username + "\n date: " + date
				+ "\n password: " + password;
	}

	/**
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws InterruptedException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws IOException,
			InterruptedException, ClassNotFoundException {
		Logon a = new Logon("Hulk", "myLittlePony");
		Print.print("logon a = " + a);
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(
				"Logon.out"));
		o.writeObject(a);
		o.close();
		TimeUnit.SECONDS.sleep(1); // Delay
		// Now get them back:
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				"Logon.out"));
		Print.print("Recovering object at " + new Date());
		a = (Logon) in.readObject();
		Print.print("logon a = " + a);
		in.close();
	}

}
