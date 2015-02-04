package net.swisstech.swissarmyknife.lang;

public final class Objects {

	/** private constructor for utility class */
	private Objects() {}

	public static <T> T notNull(T o) {
		if (o == null) {
			throw new IllegalArgumentException("Object must not be null");
		}
		return o;
	}
}
