package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class DungeonGame174Test {

	@Test
	public void test() {
		DungeonGame174 dg = new DungeonGame174();
		assertEquals(1, dg.calculateMinimumHP(new int[][] { new int[] { 0 } }));
		assertEquals(7, dg.calculateMinimumHP(new int[][] { 
			new int[] { -2, -3, 3 }, 
			new int[] { -5, -10, 1 }, 
			new int[] { 10, 30, -5 }, 
			}));
		assertEquals(4, dg.calculateMinimumHP(new int[][] { 
			new int[] { -3, 5 }, 
		}));
	}

}
