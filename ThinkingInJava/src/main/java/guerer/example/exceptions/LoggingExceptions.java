package guerer.example.exceptions;

import guerer.example.util.Print;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class LoggingException extends Exception {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger("LoggingException");
	
	LoggingException() {
		StringWriter sw = new StringWriter();
		printStackTrace(new PrintWriter(sw));
		logger.severe(sw.toString());
	}
}

public class LoggingExceptions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			throw new LoggingException();
		} catch(LoggingException e){
			Print.print("Caught " + e);
		}
	}

}
