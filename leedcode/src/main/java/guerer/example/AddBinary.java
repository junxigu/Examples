package guerer.example;

/*
 *  Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100". 
 */

public class AddBinary {
	public String addBinary(String a, String b) {
		char[] ac = new StringBuilder(a).reverse().toString().toCharArray();
		char[] bc = new StringBuilder(b).reverse().toString().toCharArray();
		if (ac.length > bc.length) {
			char[] tmp = ac;
			ac = bc;
			bc = tmp;
		}
		int j = 0;
		for (int i = 0, t = 0; i < ac.length; i++) {
			t = (ac[i] - '0') + (bc[i] - '0') + j;
			bc[i] = (char) (t % 2 + '0');
			j = t > 1 ? 1 : 0;
		}
		for (int i = ac.length, t = 0; i < bc.length; i++) {
			t = (bc[i] - '0') + j;
			bc[i] = (char) (t % 2 + '0');
			j = t > 1 ? 1 : 0;
		}
		return (j == 1 ? "1" : "")
				+ (new StringBuilder(String.valueOf(bc)).reverse().toString());
	}
}
