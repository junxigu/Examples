package third;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class TestTemplateParse {

	private List<String> parse(String template) {
		return new TemplateParse().parse(template);
	}

	private void assetSegments(List<? extends Object> actual,
			Object... expected) {
		assertEquals("Number of segments doesn't match", expected.length,
				actual.size());
		assertEquals(Arrays.asList(expected), actual);
	}

	@Test
	public void emptyTemplateRenderAsEmptyString() {
		List<String> segments = parse("");
		assetSegments(segments, "");
	}

	@Test
	public void templateWithOnlyPlainText() {
		List<String> segments = parse("plain text only");
		assetSegments(segments, "plain text only");
	}

	@Test
	public void templateWithOnlyVariable() {
		List<String> segments = parse("${one}");
		assetSegments(segments, "${one}");
	}

	@Test
	public void templateWithMultibleVariables() {
		List<String> segments = parse("${one} and ${two}");
		assetSegments(segments, "${one}", " and ", "${two}");
	}

	@Test
	public void parsingTemplateIntoSegmentObjects() {
		TemplateParse parsor = new TemplateParse();
		List<Segment> segments = parsor.parseSegments("a ${b} c ${d}");
		assetSegments(segments, new PlainText("a "), new Variable("b"),
				new PlainText(" c "), new Variable("d"));
	}

}
