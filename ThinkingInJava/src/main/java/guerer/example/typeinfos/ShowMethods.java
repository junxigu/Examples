package guerer.example.typeinfos;

import guerer.example.util.Print;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class ShowMethods {

	private static String usage = "usage:\n"
			+ "ShowMethods qualified.class.name\n"
			+ "To show all methods in class or:\n"
			+ "ShowMethods qualified.class.name word\n"
			+ "To search for methods involving 'word'";

	public static void main(String[] args) throws Exception {
		if (args.length < 1) {
			Print.print(usage);
			return;
		}
		Class<?> c = Class.forName(args[0]);
		Method[] methods = c.getMethods();
		Constructor<?>[] constructors = c.getConstructors();
		if (args.length == 1) {
			for (Method m : methods) {
				Print.print(Pattern.compile("\\w+\\.").matcher(m.toString())
						.replaceAll(""));
			}
			for (Constructor<?> constructor : constructors) {
				Print.print(Pattern.compile("\\w+\\.")
						.matcher(constructor.toString()).replaceAll(""));
			}
		} else {
			for (Method m : methods) {
				if (m.getName().indexOf(args[1]) != -1) {
					Print.print(Pattern.compile("\\w+\\.")
							.matcher(m.toString()).replaceAll(""));
				}
			}
			for (Constructor<?> constructor : constructors) {
				if (constructor.getName().indexOf(args[1]) != -1) {
					Print.print(Pattern.compile("\\w+\\.").matcher(
							constructor.toString()));
				}
			}
		}
	}

}
