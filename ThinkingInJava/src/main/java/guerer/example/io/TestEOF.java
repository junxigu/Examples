package guerer.example.io;

import guerer.example.util.Print;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class TestEOF {

	public static void main(String[] args) throws IOException {
		DataInputStream in = new DataInputStream(new ByteArrayInputStream(
				BufferedInputFile.read("TestEOF.java").getBytes()));
		while (in.available() != 0) {
			Print.print(in.readByte());
		}
	}

}
