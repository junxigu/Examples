package guerer.example.exceptions;

import guerer.example.util.Print;

//Overridden methods may throw only the exceptions
//specified in their base-class versions, or exceptions
//derived from the base-class exceptions.

class BaseballException extends Exception {
}

class Foul extends BaseballException {
}

class Strike extends BaseballException {
}

abstract class Inning {
	public Inning() throws BaseballException {
	}

	public void event() throws BaseballException {
	}

	public abstract void atBat() throws Strike, Foul;

	public void walk() {
	}
}

class StormException extends Exception {
}

class RainedOut extends StormException {
}

class PopFoul extends Foul {
}

interface Storm {
	public void event() throws RainedOut;

	public void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm {
	// OK to add new exceptions for constructors, but you
	// must deal with the base constructor exceptions:
	public StormyInning() throws BaseballException, RainedOut {
	}
	public StormyInning(String s) throws BaseballException, RainedOut {
	}

	public static void main(String[] args) {
		try {
			StormyInning si = new StormyInning();
			si.atBat();
		} catch(PopFoul e) {
			Print.print("Pop foul");
		} catch(RainedOut e) {
			Print.print("Rained out");
		} catch(BaseballException e) {
			Print.print("General baseball exception");
		}
		try {
			Inning i = new StormyInning();
			i.atBat();
		} catch(PopFoul e) {
			Print.print("Pop foul");
		} catch(RainedOut e) {
			Print.print("Rained out");
		} catch(BaseballException e) {
			Print.print("General baseball exception");
		}
	}

	// Regular methods must conform to base class :
	// ! void walk() throws PopFoul {} //Compile error
	// Interface CANNOT add exceptions to existing
	// methods from the base class:
	// ! public void event() throws RainedOut {}
	// If the method doesn't already exist in the
	// base class, the exception is OK:
	public void rainHard() throws RainedOut {
	}
	
	// You can choose to not throw any exceptions,
	// even if the base version does:
	public void event() {
	}


	// Overridden methods can throw inherited exceptions:
	@Override
	public void atBat() throws PopFoul {
		// TODO Auto-generated method stub

	}

}
