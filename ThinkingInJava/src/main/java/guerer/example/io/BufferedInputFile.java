package guerer.example.io;

import guerer.example.util.Print;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

public class BufferedInputFile {

	private static BufferedReader reader;

	public static String read(String fileName) throws IOException {
		reader = new BufferedReader(new FileReader(fileName));
		StringBuilder sb = new StringBuilder();
		String s = null;
		while ((s = reader.readLine()) != null) {
			sb.append(s);
		}
		reader.close();
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		StringReader reader = new StringReader(read(".\\src\\main\\java\\guerer\\example\\io\\BufferedInputFi1e.java"));
		int c;
		while ((c = reader.read()) != 0) {
			Print.print((char) c);
		}
	}

}
