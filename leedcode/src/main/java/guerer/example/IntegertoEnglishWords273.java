package guerer.example;

/*
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

For example,
123 -> "One Hundred Twenty Three"
12345 -> "Twelve Thousand Three Hundred Forty Five"
1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

 */
public class IntegertoEnglishWords273 {
	public String numberToWords(int num) {
		if (num == 0)
			return "Zero";

		String[] low20 = new String[] { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
				"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
				"Nineteen" };
		String[] tens = new String[] { "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
		String[] hight = new String[] { "", "Thousand", "Million", "Billion" };
		StringBuilder sb = new StringBuilder();

		int iHieght = 0;
		do {
			int tmp = num % 1000;
			if (tmp > 0) {
				sb.insert(0, " " + hight[iHieght]);

				if ((tmp % 100) < 20)
					sb.insert(0, (tmp % 100 == 0 ? "" : " " + low20[(tmp % 100)]));
				else
					sb.insert(0, " " + tens[(tmp % 100) / 10 - 2] + (tmp % 10 == 0 ? "" : " " + low20[tmp % 10]));

				if (tmp >= 100) {
					sb.insert(0, " " + low20[tmp / 100] + " Hundred");
				}
			}
			num = num / 1000;
			iHieght++;
		} while (num != 0);
		return sb.toString().trim();
	}
}
