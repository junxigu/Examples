package guerer.example.util;

public class OSExecuteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OSExecuteException(String why) {
		super(why);
	}

	public OSExecuteException(Exception e) {
		super(e);
	}
}
