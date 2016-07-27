package guerer.example.io;

import guerer.example.util.Print;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class IntBufferDemo {

	private final static int BSIZE = 1024;

	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.allocate(BSIZE);
		IntBuffer ib = bb.asIntBuffer();

		ib.put(new int[] { 11, 42, 47, 99, 143, 811, 1016 });
		Print.print(ib.get(3));

		ib.put(3, 1811);
		ib.flip();
		while (ib.hasRemaining()) {
			Print.print(ib.get());
		}
	}
}
