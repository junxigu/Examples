package guerer.example.typeinfos;

import guerer.example.util.Print;

import java.util.Random;

class Initable {
	static final int staticFinal = 47;
	static final int staticFinal2 = ClassInitialization.rand.nextInt(1008);
	static {
		System.out.println("Initializing Initable");
	}
}

class Initable2 {
	static int staticNonFinal = 147;
	static {
		System.out.println("Initializing Initable2");
	}
}

class Initable3 {
	static int staticNonFinal = 74;
	static {
		System.out.println("Initializing Initable3");
	}
}

public class ClassInitialization {

	public static Random rand = new Random(47);

	public static void main(String[] args) throws Exception {
		Class initable = Initable.class;
		Print.print("After creating Initable ref");
		
		// Does not trigger initialization
		Print.print(Initable.staticFinal);
		
		// Does trigger initialization
		Print.print(Initable.staticFinal2);
		
		// Does trigger initialization
		Print.print(Initable2.staticNonFinal);
		
		Class initable3 = Class.forName("guerer.example.typeinfos.Initable3");
		Print.print("After creating Initable3 ref");
		Print.print(Initable3.staticNonFinal);
	}
}
