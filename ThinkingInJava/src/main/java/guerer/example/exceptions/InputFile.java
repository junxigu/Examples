package guerer.example.exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputFile {
	private BufferedReader in;

	public InputFile(String name) throws Exception {
		try {
			in = new BufferedReader(new FileReader(name));
		} catch (FileNotFoundException e) {
			System.out.println("Could not open " + name);
			// Wasn't open, so don't close it
			throw e;
		} catch (Exception e) {
			// All other exceptions must close it
			try {
				in.close();
			} catch (IOException e2) {
				System.out.println("in.close() unsuccessful");
				e2.initCause(e);
				throw e2;
			}
		}
	}

	public String getLine() {
		try {
			return in.readLine();
		} catch (IOException e) {
			throw new RuntimeException("readline() fail");
		}
	}

	public void dispose() {
		try {
			in.close();
		} catch (IOException e) {
			throw new RuntimeException("close() fail");
		}
	}

}
