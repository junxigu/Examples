package guerer.example;

import org.junit.Test;

public class WordSearchII212Test {

	@Test
	public void test() {
		WordSearchII212 ws = new WordSearchII212();
		char[][] board = new char[][]{
			new char[]{'o','a','a','n'},
			new char[]{'e','t','a','e'},
			new char[]{'i','h','k','r'},
			new char[]{'i','f','l','v'},
		};
		
		System.out.println(ws.findWords(board, new String[]{"oath","pea","eat","rain"}));
		System.out.println(ws.findWords(new char[][]{
			new char[]{'a'},
		}, new String[]{"a","a",}));
	}

}
