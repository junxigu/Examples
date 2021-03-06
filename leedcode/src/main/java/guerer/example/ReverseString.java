package guerer.example;

/*
 * Write a function that takes a string as input and returns the string reversed.

 Example:
 Given s = "hello", return "olleh". 
 */

public class ReverseString {

	public String reverseString(String s) {
		if (s == null) {
			return null;
		}
		return new StringBuilder(s).reverse().toString();
	}
}
