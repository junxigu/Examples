package guerer.example.string;

public class FormatTest {

	public static void main(String[] args) {
		int i = 1;
		long l = 2l;
		float f = 3f;
		double d = 4;
		
		System.out.println(String.format("%d %d %f %f", i , l , f, d));
	}
}
