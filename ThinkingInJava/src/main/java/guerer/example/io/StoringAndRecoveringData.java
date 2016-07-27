package guerer.example.io;

import guerer.example.util.Print;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StoringAndRecoveringData {

	public static void main(String[] args) throws IOException {
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(
				new FileOutputStream("data.txt")));
		out.writeDouble(6.1);
		out.writeUTF("test 1");
		out.writeDouble(6.2);
		out.writeUTF("test 2");
		out.close();
		
		DataInputStream in = new DataInputStream(new BufferedInputStream(
				new FileInputStream("data.txt")));
		Print.print(in.readDouble());
		Print.print(in.readUTF());
		Print.print(in.readDouble());
		Print.print(in.readUTF());
		in.close();
	}
}
