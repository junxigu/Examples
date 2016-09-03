package guerer.example;

/*
 * We are playing the Guess Game. The game is as follows:

 I pick a number from 1 to n. You have to guess which number I picked.

 Every time you guess wrong, I'll tell you whether the number is higher or lower.

 You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

 -1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!

 Example:

 n = 10, I pick 6.

 Return 6.


 */

class GuessGame {
	int i;

	GuessGame(int i) {
		this.i = i;
	}

	int guess(int num) {
		return num < i ? 1 : num == i ? 0 : -1;
	}
}

public class GuessNumberHigherOrLower extends GuessGame {

	public GuessNumberHigherOrLower(int i) {
		super(i);
	}

	public int guessNumber(int n) {
		int b = 0;
		int e = n;
		int m = b + (e - b) / 2;
		int t = 0;
		while ((t = guess(m)) != 0) {
			if (t < 0) {
				e = m - 1;
			} else {
				b = m + 1;
			}
			m = b + (e - b) / 2;
		}
		return m;
	}
}
