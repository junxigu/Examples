package third;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateParse {

	private String regex = "\\$\\{[^\\}]+\\}";

	private void addPrefSegment(String template, List<String> segments,
			Matcher matcher, int lastStartIndex) {
		int start = matcher.start();
		if (lastStartIndex < start) {
			segments.add(template.substring(lastStartIndex, start));
		}
	}

	private void addEmptyOrPlainSegment(String template, List<String> segments) {
		Matcher matcher = Pattern.compile(regex).matcher(template);
		if (!matcher.find() || template.length() == 0) {
			segments.add(template);
		}
	}

	private void addVriable(String template, List<String> segments,
			Matcher matcher) {
		segments.add(template.substring(matcher.start(), matcher.end()));
	}

	private void addSegments(String template, List<String> segments) {
		Matcher matcher = Pattern.compile(regex).matcher(template);
		int lastStartIndex = 0;
		while (matcher.find()) {
			addPrefSegment(template, segments, matcher, lastStartIndex);
			addVriable(template, segments, matcher);
			lastStartIndex = matcher.end();
		}
	}

	public List<String> parse(String template) {
		List<String> segments = new ArrayList<String>();

		addSegments(template, segments);
		addEmptyOrPlainSegment(template, segments);
		return segments;
	}

	private boolean isVariable(String segment) {
		return segment.startsWith("${") && segment.endsWith("}");
	}

	public List<Segment> parseSegments(String template) {
		List<Segment> segments = new ArrayList<Segment>();
		for (String segment : parse(template)) {
			if (isVariable(segment)) {
				String name = segment.substring(2, segment.length() - 1);
				segments.add(new Variable(name));
			} else {
				segments.add(new PlainText(segment));
			}
		}
		return segments;
	}
}
