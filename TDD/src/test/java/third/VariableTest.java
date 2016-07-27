package third;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import second.MissValueException;

public class VariableTest {

	private Map<String, String> variables;

	@Before
	public void setUp() {
		variables = new HashMap<String, String>();
	}

	@Test
	public void variableEvaluatesToItsValue() {
		variables.put("a", "abc def");
		Variable segment = new Variable("a");
		assertEquals("abc def", segment.evaluate(variables));
	}

	@Test
	public void missingVariableRaisesException() {
		String name = "foo";
		try {
			new Variable(name).evaluate(variables);
			fail("evaluate should throw an Exception if a variable was left"
					+ " without a value");
		} catch (MissValueException expected) {
			assertEquals("No value for ${" + name + "}", expected.getMessage());
		}
	}

}
