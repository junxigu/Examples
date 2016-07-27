package guerer.example.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class FileOutputShortcut {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new StringReader(
				BufferedInputFile.read("data.txt")));
		PrintWriter writer = new PrintWriter("data2.txt");
		String s = null;
		while ((s = reader.readLine()) != null) {
			System.out.print(s);
			writer.write(s);
		}
		reader.close();
		writer.close();
	}

}
