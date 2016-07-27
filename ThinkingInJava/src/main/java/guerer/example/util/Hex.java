package guerer.example.util;

import java.io.IOException;

public class Hex {

	public static String format(byte[] data) {
		int n = 0;
		StringBuilder sb = new StringBuilder();
		for(byte b : data) {
			if(n % 16 == 0) {
				sb.append(String.format("%05x: ", n));
			}
			sb.append(String.format("%02x ", b));
			n++;
			if(n % 16 == 0) {
				sb.append("\n");
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		if(args.length == 0) {
			Print.print(format(BinaryFile.read("Hex.class")));
		} else{
			Print.print(format(BinaryFile.read(args[0])));
		}
	}

}
