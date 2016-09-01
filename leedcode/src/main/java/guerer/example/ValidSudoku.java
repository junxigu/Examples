package guerer.example;

/*
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

 */
public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		for(int i = 0; i < 9; i++) {
			int[] count = new int[9];
			for(int j = 0; j < 9; j++) {
				if(board[i][j] != '.') {
					if(count[board[i][j] - '1'] > 0) {
						return false;
					}
					count[board[i][j] - '1']++;
				}
			}
		}

		for(int i = 0; i < 9; i++) {
			int[] count = new int[9];
			for(int j = 0; j < 9; j++) {
				if(board[j][i] != '.') {
					if(count[board[j][i] - '1'] > 0) {
						return false;
					}
					count[board[j][i] - '1']++;
				}
			}
		}
		
		for(int i = 0; i < 9; i+= 3) {
			for(int j = 0; j < 9; j+= 3) {
				if(!checkBox(board, i , j)){
					return false;
				}
			}
		}
		return true;
	}
	
	boolean checkBox(char[][] board, int r, int c) {
		int[] count = new int[9];
		for(int i = r; i < r + 3; i++) {
			for(int j = c; j < c + 3; j++) {
				if(board[i][j] != '.') {
					if(count[board[i][j] - '1'] > 0) {
						return false;
					}
					count[board[i][j] - '1']++;
				}
			}
		}
		return true;
	}

}
