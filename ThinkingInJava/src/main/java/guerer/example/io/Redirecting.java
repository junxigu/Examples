package guerer.example.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Redirecting {

	public static void main(String[] args) throws IOException {
		PrintStream console = System.out;
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(
				new File("")));
		PrintStream out = new PrintStream(new BufferedOutputStream(
				new FileOutputStream(new File(""))));
		System.setIn(in);
		System.setOut(out);
		System.setErr(out);

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String s = null;
		while ((s = reader.readLine()) != null && s.length() > 0) {
			System.out.println(s);
		}
		out.close();
		System.setOut(console);
	}

}
