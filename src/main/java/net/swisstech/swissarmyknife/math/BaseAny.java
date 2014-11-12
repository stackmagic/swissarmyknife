package net.swisstech.swissarmyknife.math;

/**
 * encode/decode numbers into a set of symbols to shorten urls. think youtube and imgur url ids for example
 * @since 1.1.4
 */
public class BaseAny {

	private final char[] chars;

	public BaseAny(String chars) {
		this.chars = chars.toCharArray();
	}

	public BaseAny(char[] chars) {
		this.chars = chars.clone();
	}

	public String encode(double base, double value) {
		StringBuilder sb = new StringBuilder();
		encode(base, value, sb);
		return sb.toString();
	}

	private void encode(double base, double value, StringBuilder sb) {
		double div = value / base;
		double mod = value % base;

		if (div > 0) {
			if (div > base) {
				encode(base, div, sb);
			}
			else {
				int idx = (int) div;
				sb.append(chars[idx]);
			}
		}

		if (mod < base) {
			int idx = (int) mod;
			sb.append(chars[idx]);
			return;
		}

		encode(base, mod, sb);
	}

	public double decode(double base, String enc) {
		return (decode(base, enc, 0d));
	}

	private double decode(double base, String enc, double d) {

		char c = enc.charAt(0);

		double val = 0;
		for (int i = 0; i < base; i++) {
			char cc = chars[i];
			if (c == cc) {
				val = i;
			}
		}

		d = d * base + val;

		if (enc.length() > 1) {
			enc = enc.substring(1);
			return decode(base, enc, d);
		}
		else {
			return d;
		}
	}
}
