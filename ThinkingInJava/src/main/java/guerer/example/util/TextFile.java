package guerer.example.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class TextFile extends ArrayList<String> {

	private static final long serialVersionUID = 1L;

	public static String read(String fileName) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new FileReader(
				new File(fileName).getAbsoluteFile()));
		try {
			String s = null;
			while ((s = br.readLine()) != null) {
				sb.append(s).append("\n");
			}
		} finally {
			br.close();
		}
		return sb.toString();
	}

	public static void write(String fileName, String text)
			throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(
				new File(fileName).getAbsoluteFile());
		try {
			writer.print(text);
		} finally {
			writer.close();
		}
	}

	public void write(String fileName) throws FileNotFoundException {
		StringBuilder sb = new StringBuilder();
		for (String s : this) {
			sb.append(s);
		}
		write(fileName, sb.toString());
	}

	public TextFile(String fileName, String spliter) throws IOException {
		super(Arrays.asList(read(fileName).split(spliter)));
		if (get(0).equals("")) {
			remove(0);
		}
	}

	public TextFile(String fileName) throws IOException {
		this(fileName, "\n");
	}

	public static void main(String[] args) throws IOException {
		String file = read("TextFile.txt");
		write("test.txt", file);
		TextFile text = new TextFile("test.txt");
		text.write("test2.txt");
		// Break into unique sorted list of words:
		TreeSet<String> words = new TreeSet<String>(new TextFile(
				"TextFile.txt", "\\W+"));
		// Display the capitalized words:
		System.out.println(words.headSet("a"));
	}
}
