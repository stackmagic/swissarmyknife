package net.swisstech.swissarmyknife.lang;

/**
 * @since 2.1.0
 */
public final class Arrays {

	/**
	 * private constructor for utility class
	 */
	private Arrays() {
	}

	public static int[] toInt(byte[] input) {
		int[] rv = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			rv[i] = input[i] & 0xFF;
		}
		return rv;
	}
}
