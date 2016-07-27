package guerer.example.typeinfos.toys;

import guerer.example.util.Print;

interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

class Toy {
	// Comment out the following default constructor
	// to see NoSuchMethodError from (*I*)
	Toy() {
	}

	Toy(int i) {
	}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
	FancyToy() {
		super(1);
	}
}

public class ToyTest {

	public static void printInfo(Class c) {
		Print.printf("Class name: %s is interface? [%b]\n", c.getName(),
				c.isInterface());
		Print.print("Simple name: " + c.getSimpleName());
		Print.print("Canonical name: " + c.getCanonicalName());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class c = null;
		try {
			c = Class.forName("guerer.example.typeinfos.toys.FancyToy");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printInfo(c);
		for (Class cc : c.getInterfaces()) {
			printInfo(cc);
		}
		Class up = c.getSuperclass();
		Object obj = null;
		try {
			obj = up.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printInfo(obj.getClass());
	}

}
