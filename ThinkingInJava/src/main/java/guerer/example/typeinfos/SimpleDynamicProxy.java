package guerer.example.typeinfos;

import guerer.example.util.Print;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxyHandler implements InvocationHandler {

	private Interface proxied;

	DynamicProxyHandler(Interface proxied) {
		this.proxied = proxied;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Print.printf("**** proxy: %s, method: %s, args: %s\n", proxy.getClass(),
				method, args);
		if (args != null) {
			for (Object o : args) {
				Print.print(" " + o);
			}
		}
		return method.invoke(proxied, args);
	}

}

public class SimpleDynamicProxy {

	public static void main(String[] args) {
		Interface proxied = (Interface) Proxy.newProxyInstance(Interface.class
				.getClassLoader(), new Class[] { Interface.class },
				new DynamicProxyHandler(new Realobject()));
		SimpleProxyDemo.consumer(proxied);
	}
}
