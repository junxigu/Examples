package second;

import java.util.HashMap;
import java.util.List;

import third.Segment;
import third.TemplateParse;

public class Template {

	private HashMap<String, String> variables = new HashMap<String, String>();
	private TemplateParse parsor = new TemplateParse();
	private String templateText;

	public Template(String text) {
		templateText = text;
	}

	public void set(String name, String val) {
		variables.put(name, val);
	}

	private void append(StringBuilder sb, Segment segment){
		sb.append(segment.evaluate(variables));
	}
	
	private String concatenate(List<Segment> segments){
		StringBuilder sb = new StringBuilder();
		for (Segment segment : segments) {
			append(sb, segment);
		}
		
		return sb.toString();
	}
	
	public String evaluate() {
		List<Segment> segments = parsor.parseSegments(templateText);
		return concatenate(segments);
	}
}
