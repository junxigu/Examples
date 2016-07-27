package guerer.example.io;

import guerer.example.util.Print;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class UsingBuffers {

	private static void symmetricScramble(CharBuffer buff) {
		while (buff.hasRemaining()) {
			buff.mark();
			char c1 = buff.get();
			char c2 = buff.get();
			buff.reset();
			buff.put(c2).put(c1);
		}
	}

	public static void main(String[] args) {
		char[] data = "UsingBuffers".toCharArray();
		ByteBuffer buff = ByteBuffer.allocate(data.length * 2);
		CharBuffer cbuff = buff.asCharBuffer().put(data);
		Print.print(cbuff.rewind());
		symmetricScramble(cbuff);
		Print.print(cbuff.rewind());
		symmetricScramble(cbuff);
		Print.print(cbuff.rewind());
	}

}
