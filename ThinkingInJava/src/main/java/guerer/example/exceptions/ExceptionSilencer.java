package guerer.example.exceptions;

public class ExceptionSilencer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			throw new RuntimeException();
		} finally {
			return;
		}
	}

}
