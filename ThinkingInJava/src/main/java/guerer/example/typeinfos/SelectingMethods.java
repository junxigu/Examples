package guerer.example.typeinfos;

import guerer.example.util.Print;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface SomeMethods {
	void boringl();

	void boring2();

	void interesting(String arg);

	void boring3();
}

class Implementation implements SomeMethods {
	public void boringl() {
		Print.print("boringl");
	}

	public void boring2() {
		Print.print("boring2");
	}

	public void interesting(String arg) {
		Print.print("interesting " + arg);
	}

	public void boring3() {
		Print.print("boring3");
	}
}

class MethodSelector implements InvocationHandler {

	private SomeMethods proxied;

	MethodSelector(SomeMethods proxied) {
		this.proxied = proxied;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if (method.getName().equals("interesting")) {
			Print.print("Proxy detected the interesting method");
		}
		return method.invoke(proxied, args);
	}

}

public class SelectingMethods {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SomeMethods proxied = (SomeMethods) Proxy.newProxyInstance(
				SomeMethods.class.getClassLoader(),
				new Class[] { SomeMethods.class }, new MethodSelector(
						new Implementation()));
		proxied.boringl();
		proxied.boring2();
		proxied.interesting("bonobo");
		proxied.boring3();
	}

}
