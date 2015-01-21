package net.swisstech.swissarmyknife.lang;

import java.util.ArrayList;
import java.util.List;

/**
 * some String utils
 * @since 1.1.4
 */
public class Strings {

	/** private constructor for utility class */
	private Strings() {}

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

		return new StringBuilder(cs).toString();
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

		List<String> rv = new ArrayList<String>();
		for (CharSequence c : cs) {
			rv.add(asString(c));
		}
		return rv;
	}
}
