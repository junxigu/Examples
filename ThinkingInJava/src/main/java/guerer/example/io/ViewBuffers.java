package guerer.example.io;

import guerer.example.util.Print;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

public class ViewBuffers {

	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer
				.wrap(new byte[] { 0, 0, 0, 0, 0, 0, 0, 'a' });
		bb.rewind();
		Print.printnb("Byte Buffer ");
		while (bb.hasRemaining())
			Print.printnb(bb.position() + " -> " + bb.get() + ", ");
		Print.print();
		CharBuffer cb = ((ByteBuffer) bb.rewind()).asCharBuffer();
		Print.printnb("Char Buffer ");
		while (cb.hasRemaining())
			Print.printnb(cb.position() + " -> " + cb.get() + ", ");
		Print.print();
		FloatBuffer fb = ((ByteBuffer) bb.rewind()).asFloatBuffer();
		Print.printnb("F1oat Buffer ");
		while (fb.hasRemaining())
			Print.printnb(fb.position() + " -> " + fb.get() + ", ");
		Print.print();
		IntBuffer ib = ((ByteBuffer) bb.rewind()).asIntBuffer();
		Print.printnb("1nt Buffer ");
		while (ib.hasRemaining())
			Print.printnb(ib.position() + " -> " + ib.get() + ", ");
		Print.print();
		LongBuffer lb = ((ByteBuffer) bb.rewind()).asLongBuffer();
		Print.printnb("Long Buffer ");
		while (lb.hasRemaining())
			Print.printnb(lb.position() + " -> " + lb.get() + ", ");
		Print.print();
		ShortBuffer sb = ((ByteBuffer) bb.rewind()).asShortBuffer();
		Print.printnb("Short Buffer ");
		while (sb.hasRemaining())
			Print.printnb(sb.position() + " -> " + sb.get() + ", ");
		Print.print();
		DoubleBuffer db = ((ByteBuffer) bb.rewind()).asDoubleBuffer();
		Print.printnb("Doub1e Buffer ");
		while (db.hasRemaining())
			Print.printnb(db.position() + " -> " + db.get() + ", ");
	}
}
