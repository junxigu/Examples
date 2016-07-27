package guerer.example.holding;

import guerer.example.util.Generator;
import guerer.example.util.Print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class MovieGenerator implements Generator<String> {

	static final String[] MOVIES = new String[] {
			"Snow White", "Star Wars", "Movie 1", "Movie 2",
	};
	private int index = 0;
	
	public String next() {
		return MOVIES[index++ % MOVIES.length];
	}
}

public class PrintCollection {

	private static List<String> getMovies() {
		return Arrays.asList(MovieGenerator.MOVIES);
	}
	
	public static void main(String[] args) {
		List<String> coll1 = new ArrayList<String>(getMovies());
		List<String> coll2 = new LinkedList<String>(getMovies());
		Set<String> coll3 = new HashSet<String>(getMovies());
		
		Print.print(coll1);
		Print.print(coll2);
		Print.print(coll3);
	}
}
