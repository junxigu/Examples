import guerer.example.util.Print;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;

public class NumberFormatTest {

	public static void main(String[] args) throws ParseException {
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.CHINA); 
		Print.print(nf.format(1000));
		Print.print("" + nf.parse("￥10000"));
		
		nf.setCurrency(Currency.getInstance(Locale.US));
		Print.print(nf.format(1000));
	}

}
