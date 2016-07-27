package second;

public class MissValueException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public MissValueException(String messages){
		super(messages);
	}
}
