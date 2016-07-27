package guerer.example.FDCApi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegixUtil {
	private static Pattern tokenPattern = Pattern
			.compile("\"\\s*token\\s*\"\\s*:\\s*\"(\\w+)\"");
	private static Pattern instanceIdPattern = Pattern
			.compile("\"\\s*WL-Instance-Id\\s*\"\\s*:\\s*\"(\\w+)\"");
	private static Pattern sessionTokenPattern = Pattern
			.compile("\"\\s*sessionToken\\s*\"\\s*:\\s*\"(\\w+)\"");

	private static String parseValueFromStringByPattern(Pattern pattern,
			String str) {
		Matcher m = pattern.matcher(str);
		return m.find() ? m.group(1) : "";
	}

	public static String parseToken(String response) {
		return parseValueFromStringByPattern(tokenPattern, response);
	}

	public static String parseInstanceId(String response) {
		return parseValueFromStringByPattern(instanceIdPattern, response);
	}
	
	public static String parseSessionToken(String response) {
		return parseValueFromStringByPattern(sessionTokenPattern, response);
	}
}