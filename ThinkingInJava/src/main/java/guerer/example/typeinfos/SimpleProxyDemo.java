package guerer.example.typeinfos;

import guerer.example.util.Print;

interface Interface {
	void doSomething();

	void somethingElse(String arg);
}

class Realobject implements Interface {
	public void doSomething() {
		Print.print("doSomething");
	}

	public void somethingElse(String arg) {
		Print.print("somethingElse " + arg);
	}
}

class SimpleProxy implements Interface {
	private Interface proxied;

	public SimpleProxy(Interface proxied) {
		this.proxied = proxied;
	}

	public void doSomething() {
		Print.print("SimpleProxy doSomething");
		proxied.doSomething();
	}

	public void somethingElse(String arg) {
		Print.print("SimpleProxy somethingElse " + arg);
		proxied.somethingElse(arg);
	}
}

public class SimpleProxyDemo {
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("bonobo");
	}

	public static void main(String[] args) {
		consumer(new Realobject());
		consumer(new SimpleProxy(new Realobject()));
	}
}
