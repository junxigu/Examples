package guerer.example.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.sun.istack.internal.logging.Logger;

public class LoggingException {

	static class Exception1 extends Exception {

		Exception1() {
			Logger logger = Logger.getLogger(getClass());
			StringWriter s = new StringWriter();
			printStackTrace(new PrintWriter(s));
			logger.severe(s.toString());
		}
	}

	static class Exception2 extends Exception {

		Exception2() {
			Logger logger = Logger.getLogger(getClass());
			StringWriter s = new StringWriter();
			printStackTrace(new PrintWriter(s));
			logger.severe(s.toString());
		}
	}

	public static void main(String[] args) {
		try {
			throw new Exception1();
		} catch (Exception e) {

		}
		try {
			throw new Exception2();
		} catch (Exception e) {

		}
	}
}
