package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlienDictionary269Test {

	@Test
	public void test() {
		AlienDictionary269 ad = new AlienDictionary269();
		System.out.println(ad.alienOrder(new String[] { "wrt", "wrf", "er", "ett", "rftt" }));
		System.out.println(ad.alienOrder(new String[] { "a", "b", "a" }));
	}

}
