package guerer.example;

/*
 * Reverse bits of a given 32 bits unsigned integer.

 For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

 Follow up:
 If this function is called many times, how would you optimize it?

 Related problem: Reverse Integer
 */

public class ReverseBits {
	// you need treat n as an unsigned value
	public int reverseBits(int n) {
		StringBuilder sb = new StringBuilder(Integer.toBinaryString(n));
		sb.reverse();
		for (int i = sb.length(); i < 32; i++) {
			sb.append('0');
		}
		int sum = 0;
		for (char c : sb.toString().toCharArray()) {
			sum = sum * 2 + (c - '0');
		}
		return sum;
	}
}
