package third;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class PlainTextTest {

	@Test
	public void test() {
		Map<String, String> variables = new HashMap<String, String>();
		PlainText segment = new PlainText("abc def");
		assertEquals("abc def", segment.evaluate(variables));
	}

}
