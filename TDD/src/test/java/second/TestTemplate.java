package second;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class TestTemplate {

	private Template template;

	private void assetTemplateEvaluatesTo(String expected) {
		assertEquals(expected, template.evaluate());
	}

	@Before
	public void setUp() throws Exception {
		template = new Template("${one}, ${two}, ${three}");
		template.set("one", "1");
		template.set("two", "2");
		template.set("three", "3");
	}

	@Test
	public void multipuleVaribles() throws Exception {
		assetTemplateEvaluatesTo("1, 2, 3");
	}

	@Test
	public void unknownVariablesIgnored() throws Exception {
		template.set("doesnotexist", "Hi");
		assetTemplateEvaluatesTo("1, 2, 3");
	}

	@Test
	public void missingValueRaiseException() throws Exception{
		try{
			new Template("${foo}").evaluate();
			fail("evaluate should throw an Exception if a variable was left" +
					" without a value");
		} catch(MissValueException expected){
			assertEquals("No value for ${foo}", expected.getMessage());
		}
	}
	
	@Test
	public void variablesGetProcessJustOnce() throws Exception{
		template.set("one", "${one}");
		template.set("two", "${three}");
		template.set("three", "${two}");
		assetTemplateEvaluatesTo("${one}, ${three}, ${two}");
	}
	
}
