package net.swisstech.swissarmyknife.math;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * encode/decode numbers into a set of symbols to shorten urls. think youtube and imgur url ids for example
 *
 * @since 1.1.4
 */
public class BaseAny {

	private final char[] chars;
	private final double base;
	private final BigDecimal baseDecimal;

	public BaseAny(String chars) {
		this(chars.toCharArray());
	}

	public BaseAny(char[] chars) {
		this.chars = verifyChars(chars.clone());
		this.base = chars.length;
		this.baseDecimal = new BigDecimal(base);
	}

	public String encode(BigDecimal value) {
		StringBuilder sb = new StringBuilder();
		encode(value, sb);
		return sb.toString();
	}

	private void encode(BigDecimal value, StringBuilder sb) {
		BigDecimal[] divMod = value.divideAndRemainder(baseDecimal);
		BigDecimal div = divMod[0];
		BigDecimal mod = divMod[1];

		if (div.compareTo(BigDecimal.ONE) >= 0) {
			if (baseDecimal.compareTo(div) < 0) {
				encode(div, sb);
			} else {
				int idx = div.intValue();
				sb.append(chars[idx]);
			}
		}

//		if (baseDecimal.compareTo(mod) > 0) {
		int idx = mod.intValue();
		sb.append(chars[idx]);
//			return;
//		}

//		encode(mod, sb);
	}

	public BigDecimal decode(String enc) {
		return decode(enc, BigDecimal.ZERO);
	}

	private BigDecimal decode(String enc, BigDecimal d) {
		char c = enc.charAt(0);

		int val = 0;
		for (int i = 0; i < base; i++) {
			char cc = chars[i];
			if (c == cc) {
				val = i;
				break;
			} else if (i + 1 == base) {
				throw new IllegalArgumentException("Invalid character '" + c + "', not found in symbol list");
			}
		}

		// shift by 1 position
		d = d.multiply(baseDecimal);

		// add value for this decoded character
		d = d.add(new BigDecimal(val));

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
