package net.swisstech.swissarmyknife.lang;

public final class Objects {

	/**
	 * private constructor for utility class
	 */
	private Objects() {
	}

	public static <T> T notNull(T o) {
		return notNull(o, "");
	}

	/**
	 * @since 2.1.0
	 */
	public static <T> T notNull(T o, String name) {
		if (o == null) {
			throw new IllegalArgumentException("Object " + name + " must not be null");
		}
		return o;
	}
}
