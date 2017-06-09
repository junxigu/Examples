package guerer.example;

import java.util.Arrays;

/*
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 */

public class WordSearch79 {
	public boolean exist(char[][] board, String word) {
		if (word.length() == 0)
			return false;

		char c = word.charAt(0);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == c && find(board, i, j, word)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean find(char[][] board, int i, int j, String word) {
		// System.out.println("i: " + i + ", j: " + j + ", word: " + word);
		// for(char[] cs : board)
		// System.out.println(Arrays.toString(cs));
		// System.out.println();

		if (word.length() <= 1)
			return true;

		boolean finded = false;
		char old = board[i][j];
		board[i][j] = 0;
		word = word.substring(1);

		if (!finded)
			finded = findForNewIJ(board, i - 1, j, word);
		if (!finded)
			finded = findForNewIJ(board, i + 1, j, word);
		if (!finded)
			finded = findForNewIJ(board, i, j - 1, word);
		if (!finded)
			finded = findForNewIJ(board, i, j + 1, word);

		board[i][j] = old;
		return finded;
	}

	private boolean findForNewIJ(char[][] board, int newI, int newJ, String word) {
		if (newI < board.length && newI >= 0 && newJ < board[newI].length && newJ >= 0) {
			if (board[newI][newJ] != 0 && board[newI][newJ] == word.charAt(0)) {
				if (find(board, newI, newJ, word)) {
					return true;
				}
			}
		}
		return false;
	}
}
