package guerer.example.io;

import guerer.example.util.Print;

import java.nio.ByteBuffer;

public class GetData {

	private static final int BSIZE = 1024;

	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.allocate(BSIZE);
		// Allocation automatically zeroes the ByteBuffer:
		int i = 0;
		while (i++ < bb.limit())
			if (bb.get() != 0)
				Print.print("nonzero");
		Print.print("i = " + i);
		bb.rewind();

		// Store and read a char array:
		bb.asCharBuffer().put("Howdy!");
		char c;
		while ((c = bb.getChar()) != 0)
			Print.printnb(c + " ");
		Print.print();
		bb.rewind();

		// Store and read a short:
		bb.asShortBuffer().put((short) 471142);
		Print.print(bb.getShort());
		bb.rewind();

		// Store and read an int:
		bb.asIntBuffer().put(99471142);
		Print.print(bb.getInt());
		bb.rewind();

		// Store and read a long:
		bb.asLongBuffer().put(99471142L);
		Print.print(bb.getLong());
		bb.rewind();

		// Store and read a float:
		bb.asFloatBuffer().put(99471142);
		Print.print(bb.getFloat());
		bb.rewind();

		// Store and read a double:
		bb.asDoubleBuffer().put(99471142);
		Print.print(bb.getDouble());
		bb.rewind();
	}

}
