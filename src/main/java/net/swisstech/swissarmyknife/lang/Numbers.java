package net.swisstech.swissarmyknife.lang;

/**
 * some number utilities
 *
 * @since 1.1.4
 */
public final class Numbers {

	/**
	 * private constructor for utility class
	 */
	private Numbers() {
	}

	public static Long tryParseLong(String text, Long def) {
		if (text == null) {
			return def;
		}
		try {
			return Long.parseLong(text);
		} catch (NumberFormatException e) {
			return def;
		}
	}

	public static Long tryParseLong(String text) {
		return tryParseLong(text, null);
	}

	public static Integer tryParseInt(String text, Integer def) {
		if (text == null) {
			return def;
		}
		try {
			return Integer.parseInt(text);
		} catch (NumberFormatException e) {
			return def;
		}
	}

	public static Integer tryParseInt(String text) {
		return tryParseInt(text, null);
	}

	public static Double tryParseDouble(String text) {
		return tryParseDouble(text, null);
	}

	public static Double tryParseDouble(String text, Double def) {
		if (text == null) {
			return def;
		}
		try {
			return Double.parseDouble(text);
		} catch (NumberFormatException e) {
			return def;
		}
	}
}
