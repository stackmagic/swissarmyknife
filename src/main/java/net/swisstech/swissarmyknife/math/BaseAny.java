package net.swisstech.swissarmyknife.math;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * encode/decode numbers into a set of symbols to shorten urls. think youtube and imgur url ids for example
 *
 * @since 1.1.4
 */
public class BaseAny {

    private final char[] chars;
    private final int base;
    private final BigInteger baseDecimal;

    public BaseAny(String chars) {
        this(chars.toCharArray());
    }

    public BaseAny(char[] chars) {
        this.chars = verifyChars(chars.clone());
        this.base = chars.length;
        this.baseDecimal = BigInteger.valueOf(base);
    }

    public String encode(BigInteger value) {
        StringBuilder sb = new StringBuilder();
        encode(value, sb);
        return sb.toString();
    }

    private void encode(BigInteger value, StringBuilder sb) {
        BigInteger[] divMod = value.divideAndRemainder(baseDecimal);
        BigInteger div = divMod[0];
        BigInteger mod = divMod[1];

        if (div.compareTo(BigInteger.ONE) >= 0) {
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

    public BigInteger decode(String enc) {
        return decode(enc, BigInteger.ZERO);
    }

    private BigInteger decode(String enc, BigInteger d) {
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
        d = d.add(BigInteger.valueOf(val));

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
