package net.swisstech.swissarmyknife.lang;

/** some String utils */
public class Strings {

	/** private constructor for utility class */
	private Strings() {}

	public static boolean isEmpty(String s) {
		return s == null || s.trim().isEmpty();
	}

	public static boolean isNotEmpty(String s) {
		return !isEmpty(s);
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
