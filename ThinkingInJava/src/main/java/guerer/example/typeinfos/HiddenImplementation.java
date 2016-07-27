package guerer.example.typeinfos;

import guerer.example.typeinfos.interfacea.A;
import guerer.example.typeinfos.packageaccess.HiddenC;
import guerer.example.util.Print;

import java.lang.reflect.Method;

public class HiddenImplementation {

	public static void main(String[] args) throws Exception {
		A a = HiddenC.makeA();
		a.f();
		Print.print(a.getClass().getName());

		// Compile error: cannot find symbol 'C':
		/*
		 * if(a instanceof C) { C c = (C)a; c.go; }
		 */
		
		callHiddenMethod(a, "g");
		callHiddenMethod(a, "u");
		callHiddenMethod(a, "v");
		callHiddenMethod(a, "w");
	}
	
	static void callHiddenMethod(Object a, String name) throws Exception {
		Class c = a.getClass();
		Method m = c.getDeclaredMethod(name);
		m.setAccessible(true);
		m.invoke(a);
	}

}
