package net.swisstech.swissarmyknife.util;

import java.util.Random;

/**
 * some utils for random numbers
 * @since 1.2.0
 */
public final class Randoms {

	public static final Random RNG = new Random();

	/** private constructor for utility class */
	private Randoms() {}

	public static int nextIntInclusive(int lo, int hi) {
		return lo + RNG.nextInt(hi - lo);
	}
}
