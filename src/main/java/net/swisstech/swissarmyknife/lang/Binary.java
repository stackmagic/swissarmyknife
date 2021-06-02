package net.swisstech.swissarmyknife.lang;

/**
 * utils related to the powers of two!
 *
 * @since 1.1.4
 */
public final class Binary {

    /** private constructor for utility class */
    private Binary() {
    }

    public static boolean isPowerOfTwo(long num) {
        return (num & (num - 1)) == 0;
    }

    public static int countLeadingZeroes(byte[] bytes) {
        int count = 0;

        // use int so we don't have to deal with +/-
        // byte range: -128..127
        // as int: 0..255
        for (byte b : bytes) {

            int i = Byte.toUnsignedInt(b);
            // byte fully zeroes, continue to next byte
            if (i < 1) {
                count += 8;
                continue;
            }

            // byte partially or no zeroes at all, abort after this
            if (i < 2) {
                count += 7;
            } else if (i < 4) {
                count += 6;
            } else if (i < 8) {
                count += 5;
            } else if (i < 16) {
                count += 4;
            } else if (i < 32) {
                count += 3;
            } else if (i < 64) {
                count += 2;
            } else if (i < 128) {
                count += 1;
            }

            break;
        }

        return count;
    }
}
