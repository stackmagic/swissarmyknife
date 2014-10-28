package net.swisstech.swissarmyknife.lang;

/** utils related to the powers of two! */
public final class Binary {

	/** private constructor for utility class */
	private Binary() {}

	public static boolean isPowerOfTwo(long num) {
		return (num & (num - 1)) == 0;
	}
}
