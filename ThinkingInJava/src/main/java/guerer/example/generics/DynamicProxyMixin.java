package guerer.example.generics;

import guerer.example.util.Tuple;
import guerer.example.util.TwoTuple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MixinProxy implements InvocationHandler {

	private Map<String, Object> methods = new HashMap<String, Object>();

	public MixinProxy(TwoTuple<Object, Class<?>>... tuples) {
		for (TwoTuple<Object, Class<?>> tuple : tuples) {
			for (Method m : tuple.second.getMethods()) {
				methods.put(m.getName(), tuple.first);
			}
		}
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		return method.invoke(methods.get(method.getName()), args);
	}

	public static Object newInstance(TwoTuple... tuples) {
		List<Class<?>> interfaces = new ArrayList<Class<?>>();
		for (TwoTuple<Object, Class<?>> tuple : tuples) {
			interfaces.add(tuple.second);
		}

		return Proxy.newProxyInstance(tuples.getClass().getClassLoader(),
				interfaces.toArray(new Class<?>[tuples.length]),
				new MixinProxy(tuples));
	}
}

public class DynamicProxyMixin {

	public static void main(String[] args) {
		Object mixin = MixinProxy.newInstance(
				Tuple.tuple(new BasicImp(), Basic.class),
				Tuple.tuple(new TimeStampedImp(), TimeStamped.class),
				Tuple.tuple(new SerialNumberedImp(), SerialNumbered.class));
		Basic b = (Basic) mixin;
		TimeStamped t = (TimeStamped) mixin;
		SerialNumbered s = (SerialNumbered) mixin;
		b.set("Hello");
		System.out.println(b.get());
		System.out.println(t.getStamp());
		System.out.println(s.getSerialNumber());
	}
}
