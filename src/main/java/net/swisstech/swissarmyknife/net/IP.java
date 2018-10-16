package net.swisstech.swissarmyknife.net;

/**
 * some utils for working with the ip layer
 *
 * @since 1.2.0
 */
public final class IP {

	/**
	 * lowest possible octet in an ip
	 */
	public static final int MIN_OCTET = 0;

	/**
	 * highest possible octet in an ip
	 */
	public static final int MAX_OCTET = (int) Math.pow(2, 8) - 1;

	/**
	 * private constructor for utility class
	 */
	private IP() {
	}

	// TODO create random local ips as byte[] or string for use in tests
	// TODO validator/check methods
}
