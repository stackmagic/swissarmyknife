package net.swisstech.swissarmyknife.math;

import java.util.HashSet;
import java.util.Set;

/**
 * encode/decode numbers into a set of symbols to shorten urls. think youtube and imgur url ids for example
 *
 * @since 1.1.4
 */
public class BaseAny {

	private final char[] chars;

	public BaseAny(String chars) {
		this(chars.toCharArray());
	}

	public BaseAny(char[] chars) {
		this.chars = verifyChars(chars.clone());
	}

	public String encode(double value) {
		StringBuilder sb = new StringBuilder();
		encode(value, sb);
		return sb.toString();
	}

	private void encode(double value, StringBuilder sb) {
		double base = chars.length;
		double div = value / base;
		double mod = value % base;

		if (div > 0) {
			if (div > base) {
				encode(div, sb);
			} else {
				int idx = (int) div;
				sb.append(chars[idx]);
			}
		}

		if (mod < base) {
			int idx = (int) mod;
			sb.append(chars[idx]);
			return;
		}

		encode(mod, sb);
	}

	public double decode(String enc) {
		return decode(enc, 0d);
	}

	private double decode(String enc, double d) {
		double base = chars.length;
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
			return decode(enc, d);
		} else {
			return d;
		}
	}

	private char[] verifyChars(char[] chars) {
		Set<Character> s = new HashSet<>();
		for (char c : chars) {
			s.add(c);
		}

		int unique = s.size();
		int symbols = chars.length;
		if (unique != symbols) {
			throw new IllegalArgumentException("Supplied characters must be unique! Got " + symbols + " chars but there are only " + unique + " unique characters");
		}

		return chars;
	}
}
