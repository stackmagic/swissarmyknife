package net.swisstech.swissarmyknife.net;

import static net.swisstech.swissarmyknife.lang.Integers.inRangeInclusive;
import static net.swisstech.swissarmyknife.lang.Integers.isInRangeInclusive;
import net.swisstech.swissarmyknife.util.Randoms;

/**
 * some utils for working with the tcp layer
 * @since 1.2.0
 */
public final class TCP {

	/** lowest possible port number */
	public static final int MIN_PORT = 0;

	/** lowest port number useable for unprivileged users to open listening ports on */
	public static final int MIN_PORT_UNPRIV = (int) Math.pow(2, 10);

	/** highest possible port number */
	public static final int MAX_PORT = (int) Math.pow(2, 16) - 1;

	/** private constructor for utility class */
	private TCP() {}

	public static int getRandomUnprivilegedPort() {
		return Randoms.nextIntInclusive(MIN_PORT_UNPRIV, MAX_PORT);
	}

	public static int validPortNUmber(int port) {
		return inRangeInclusive(port, MIN_PORT, MAX_PORT);
	}

	public static boolean isValidPortNumber(int port) {
		return isInRangeInclusive(port, MIN_PORT, MAX_PORT);
	}
}
