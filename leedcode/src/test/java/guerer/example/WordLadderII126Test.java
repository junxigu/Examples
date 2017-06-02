package guerer.example;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class WordLadderII126Test {

	@Test
	public void testFindLadders() {
		WordLadderII126 wl = new WordLadderII126();
		System.out.println(wl.findLadders("hit", "cog",
				Arrays.asList(new String[] { "hot", "dot", "dog", "lot", "log", "cog" })));
		System.out.println(wl.findLadders("hot", "dog",
				Arrays.asList(new String[] { "hot", "dog" })));
		System.out.println(wl.findLadders("qa", "sq",
				Arrays.asList(new String[] { "si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln",
						"tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn",
						"ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo",
						"as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz",
						"no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er",
						"sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he",
						"lr", "sq", "ye" })));
		
	}
	
	@Test
	public void testGenerateLayers() {
		String begin = "hit";
		String end = "cog";
		Set<String> wordList = new HashSet<String>(Arrays.asList(new String[] { "hot", "dot", "dog", "lot", "log", "cog" }));
		List<List<Map<String, Set<String>>>> layers = new ArrayList<List<Map<String, Set<String>>>>();
		WordLadderII126 wl = new WordLadderII126();
		// Generate the map layers
		System.out.println(wl.generateLayers(layers, begin, end, new HashSet<String>(wordList)));
		
//		WordLadderII126 wl = new WordLadderII126();
//		System.out.println(wl.findLadders("hit", "cog",
//				Arrays.asList(new String[] { "hot", "dot", "dog", "lot", "log", "cog" })));
//		System.out.println(wl.findLadders("hot", "dog",
//				Arrays.asList(new String[] { "hot", "dog" })));
//		System.out.println(wl.findLadders("qa", "sq",
//				Arrays.asList(new String[] { "si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln",
//						"tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn",
//						"ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo",
//						"as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz",
//						"no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er",
//						"sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he",
//						"lr", "sq", "ye" })));
		
	}

	@Test
	public void diff() {
		WordLadderII126 wl = new WordLadderII126();

		assertTrue(wl.diff("hit", "cog") == 3);
		assertTrue(wl.diff("hit", "hot") == 1);
	}

}
