package guerer.example;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

public class WordLadderII126Test {

//	@Ignore
	@Test
	public void testFindLadders() {
		WordLadderII126 wl = new WordLadderII126();
		System.out.println(wl.findLadders("hit", "cog",
				Arrays.asList(new String[] { "hot","dot","dog","lot","log","cog" })));
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
	
	@Ignore
	@Test
	public void testBFS() {
		WordLadderII126 wl = new WordLadderII126();
		Map<String, List<String>> m1 = new HashMap<String, List<String>>();
		System.out.println(wl.BFS("hit", "cog", new HashSet<String>(Arrays.asList(new String[] { "hot", "dot", "dog", "lot", "log", "cog" })), m1));
		System.out.println(m1);
		
		Map<String, List<String>> m2 = new HashMap<String, List<String>>();
		System.out.println(wl.BFS("hot", "dog", new HashSet<String>(Arrays.asList( "hot", "dog")), m2));
		System.out.println(m2);
		
		Map<String, List<String>> m3 = new HashMap<String, List<String>>();
		System.out.println(wl.BFS("qa", "sq", new HashSet<String>(Arrays.asList(new String[] { "si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln",
				"tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn",
				"ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo",
				"as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz",
				"no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er",
				"sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he",
				"lr", "sq", "ye" })), m3));
		System.out.println(m3);
	}

	@Ignore
	@Test
	public void diff() {
		WordLadderII126 wl = new WordLadderII126();

		assertTrue(wl.diff("hit", "cog") == 3);
		assertTrue(wl.diff("hit", "hot") == 1);
	}

}
