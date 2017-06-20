package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class JumpGameII45Test {

	@Test
	public void testJump() {
		JumpGameII45 jg = new JumpGameII45();
		assertEquals(2, jg.jump(new int[]{2,3,1,1,4}));
		assertEquals(2, jg.jump(new int[]{2}));
		assertEquals(1, jg.jump(new int[]{1, 2}));
		assertEquals(1, jg.jump(new int[]{2, 1}));
		assertEquals(2, jg.jump(new int[]{2,3,0,1,4}));
	}

}
