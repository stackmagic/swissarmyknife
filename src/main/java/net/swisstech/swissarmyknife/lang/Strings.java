package net.swisstech.swissarmyknife.lang;

/** some String utils */
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
			throw new IllegalArgumentException("String shouldn't be empty but gut " + s);
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
}
