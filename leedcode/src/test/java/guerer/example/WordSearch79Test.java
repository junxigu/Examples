package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordSearch79Test {

	@Test
	public void test() {
		WordSearch79 ws = new WordSearch79();
		char[][] board = new char[][]{
			new char[]{'A','B','C','E'},
			new char[]{'S','F','C','S'},
			new char[]{'A','D','E','E'},
		};
		
		assertTrue(ws.exist(board, "ABCCED"));
		assertTrue(ws.exist(board, "SEE"));
		assertFalse(ws.exist(board, "ABCB"));
	}

}
