package net.swisstech.swissarmyknife.lang;

/** some String utils */
public class Strings {

	public static boolean isEmpty(String s) {
		return s == null || s.trim().isEmpty();
	}

	public static boolean isNotEmpty(String s) {
		return !isEmpty(s);
	}
}
