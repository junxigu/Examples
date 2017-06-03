package guerer.example;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;

public class FindTheClosestPalindrome564Test {

	FindTheClosestPalindrome564 ftp = new FindTheClosestPalindrome564();
//	@Ignore
	@Test
	public void testNearestPalindromic() {
		assertEquals(ftp.nearestPalindromic("1234"), "1221");
		assertEquals(ftp.nearestPalindromic("1001"), "999");
		assertEquals(ftp.nearestPalindromic("999"), "1001");
		assertEquals(ftp.nearestPalindromic("123"), "121");
		assertEquals(ftp.nearestPalindromic("13"), "11");
		assertEquals(ftp.nearestPalindromic("33"), "22");
		assertEquals(ftp.nearestPalindromic("32"), "33");
		assertEquals(ftp.nearestPalindromic("9"), "8");
		assertEquals(ftp.nearestPalindromic("1"), "0");
		assertEquals(ftp.nearestPalindromic("0"), "1");
	}

	@Test
	public void testFindNearestDownerPalindrom() {
		assertEquals(ftp.findNextNearestDownerPalindrom("1001"), "999");
		assertEquals(ftp.findNextNearestDownerPalindrom("123"), "111");
		assertEquals(ftp.findNextNearestDownerPalindrom("13"), "9");
		assertEquals(ftp.findNextNearestDownerPalindrom("33"), "22");
		assertEquals(ftp.findNextNearestDownerPalindrom("32"), "22");
		assertEquals(ftp.findNextNearestDownerPalindrom("9"), "8");
		assertEquals(ftp.findNextNearestDownerPalindrom("1"), "0");
		assertEquals(ftp.findNextNearestDownerPalindrom("0"), "");
	}

	@Ignore
	@Test
	public void testReverseCopy() {
		char[] a = new char[]{'2', '1'};
		char[] b = new char[]{'3'};
		ftp.reverseCopy(a, b);
		System.out.println(Arrays.toString(a) + ", " + Arrays.toString(b));
		
		a = new char[]{'2', '1'};
		b = new char[]{'3', '4'};
		ftp.reverseCopy(a, b);
		System.out.println(Arrays.toString(a) + ", " + Arrays.toString(b));
		
		a = new char[]{'2', '1'};
		b = new char[]{'3', '4', '5'};
		ftp.reverseCopy(a, b);
		System.out.println(Arrays.toString(a) + ", " + Arrays.toString(b));
	}

	@Test
	public void testFindNextNearestUpperPalindrom() {
		assertEquals(ftp.findNextNearestUpperPalindrom("999"), "1001");
		assertEquals(ftp.findNextNearestUpperPalindrom("123"), "131");
		assertEquals(ftp.findNextNearestUpperPalindrom("13"), "22");
		assertEquals(ftp.findNextNearestUpperPalindrom("33"), "44");
		assertEquals(ftp.findNextNearestUpperPalindrom("32"), "44");
		assertEquals(ftp.findNextNearestUpperPalindrom("9"), "11");
		assertEquals(ftp.findNextNearestUpperPalindrom("1"), "2");
	}

}
