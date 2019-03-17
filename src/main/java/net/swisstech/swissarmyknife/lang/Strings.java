package net.swisstech.swissarmyknife.lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * some String utils
 *
 * @since 1.1.4
 */
public class Strings {

	/**
	 * private constructor for utility class
	 */
	private Strings() {
	}

	/**
	 * @since 2.1.0
	 */
	public static String valueOrDefault(String str, String dflt) {
		if (isBlank(str)) {
			return dflt;
		}
		return str;
	}

	/**
	 * @since 2.1.0
	 */
	public static String joinNonBlank(String delimiter, String... parts) {
		if (delimiter == null) {
			throw new IllegalArgumentException("Delimiter must not be null");
		}
		if (parts == null) {
			throw new IllegalArgumentException("Parts to join must not be null");
		}
		List<String> nonNull = Arrays.stream(parts).filter(Strings::isNotBlank).collect(Collectors.toList());
		return String.join(delimiter, nonNull);
	}

	public static boolean isBlank(String s) {
		return s == null || s.trim().isEmpty();
	}

	public static String blank(String s) {
		if (isNotBlank(s)) {
			throw new IllegalArgumentException("String should be blank but got " + s);
		}
		return s;
	}

	public static boolean isNotBlank(String s) {
		return !isBlank(s);
	}

	public static String notBlank(String s) {
		if (isBlank(s)) {
			throw new IllegalArgumentException("String shouldn't be empty but got " + s);
		}
		return s;
	}

	public static String truncate(String string, int length) {
		int len = string.length();
		if (len < length) {
			return string;
		}

		int diff = len - length;
		StringBuilder sb = new StringBuilder();
		sb.append(string.substring(0, length));
		sb.append("... (");
		sb.append(diff);
		sb.append(" Bytes skipped)");
		return sb.toString();
	}

	public static String asString(CharSequence cs) {
		if (cs == null) {
			return null;
		}

		if (cs instanceof String) {
			return (String) cs;
		}

		return String.valueOf(cs);
	}

	public static String[] asString(CharSequence[] cs) {
		if (cs == null) {
			return null;
		}

		String[] s = new String[cs.length];
		for (int i = 0; i < s.length; i++) {
			s[i] = asString(cs[i]);
		}

		return s;
	}

	public static List<String> asString(List<CharSequence> cs) {
		if (cs == null) {
			return null;
		}

		List<String> rv = new ArrayList<>();
		for (CharSequence c : cs) {
			rv.add(asString(c));
		}
		return rv;
	}

	/**
	 * Break a String by a given delimiter and group it into chunks no larger than indicated by
	 * maxLineLength. The StringSizeMeasurer can return an arbitrary measure such as character
	 * count or pixel width when rendered.
	 *
	 * @param text               The Text to be split
	 * @param delimiter          The Delimiter to split the text by
	 * @param maxLineLength      The maximum length a line is allowed to take up
	 * @param stringSizeMeasurer Callback to calculate the size of a string to determine when to begin a new line
	 * @return List of Strings with a length no greater than maxLineLength, including all delimiters.
	 */
	public static List<String> breakString(String text, String delimiter, int maxLineLength, StringSizeMeasurer stringSizeMeasurer) {
		StringTokenizer st = new StringTokenizer(text, delimiter, true);
		List<String> out = new ArrayList<>();

		String currentPart = "";
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			String nextPart = currentPart + token;

			if (maxLineLength < stringSizeMeasurer.measureLength(nextPart)) {
				if (currentPart.length() > 0) {
					out.add(currentPart);
				}
				currentPart = token;
			} else {
				currentPart = nextPart;
			}
		}

		if (currentPart.length() > 0) {
			out.add(currentPart);
		}

		return out;
	}

	/**
	 * Functional interface to measure the "size" of a string.
	 * This could be the number of characters or the size in pixels
	 * it takes up on a screen (like the calculation done by
	 * android.graphics.Paint::measureText)
	 */
	public interface StringSizeMeasurer {
		int measureLength(String string);
	}
}
