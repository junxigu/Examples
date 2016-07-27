package guerer.example.io;

import guerer.example.util.Print;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class LargeMappedFiles {

	static int length = 0x8FFFFFF; // 128 MB

	public static void main(String[] args) throws IOException {
		MappedByteBuffer out = new RandomAccessFile("test.dat", "rw")
				.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);
		for (int i = 0; i < length; i++)
			out.put((byte) 'x');
		Print.print("Finished writting");
		for (int i = length / 2; i < length / 2 + 6; i++)
			Print.printnb((char) out.get(i));
	}

}
