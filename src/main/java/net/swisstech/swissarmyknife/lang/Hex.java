package net.swisstech.swissarmyknife.lang;

/**
 * Hex Utils, namely dumping byte[] into a human-friendly hexdump
 * @since 1.1.4
 */
public final class Hex {

	private static final int BYTES_PER_LINE_MID_LINE_BREAK_IDX = 7;
	private static final int BYTES_PER_LINE_MAX_IDX = 15;

	private static final int BYTES_PER_LINE = 16;

	private static final int ASCII_START = 32;
	private static final int ASCII_END = 126;

	/** private constructor for utility class */
	private Hex() {}

	public static String toHexDumpString(int[] data) {

		StringBuilder lines = new StringBuilder();
		StringBuilder dec = null;
		int ccount = 0;
		for (int i = 0; i < data.length; i++) {
			ccount++;

			// beginning of line hex index
			if (i % BYTES_PER_LINE == 0) {
				lines.append(String.format("%04X-%04X    ", i, i + BYTES_PER_LINE));
				dec = new StringBuilder();
			}

			// hex and ascii blocks
			lines.append(String.format("%02X ", data[i]));
			if (data[i] < ASCII_START || data[i] > ASCII_END) {
				dec.append(".");
			}
			else {
				dec.append((char) data[i]);
			}

			// mid-block space
			if (i % BYTES_PER_LINE == BYTES_PER_LINE_MID_LINE_BREAK_IDX) {
				lines.append(" ");
				dec.append(" ");
			}

			// end of data padding so last hex and ascii lines parts are aligned
			if (i + 1 == data.length) {
				for (int x = i; x % BYTES_PER_LINE != 15; x++) {
					lines.append("   ");
					dec.append(" ");
				}
			}

			// append ascii part to hex part
			if (i % BYTES_PER_LINE == BYTES_PER_LINE_MAX_IDX || i + 1 == data.length) {
				lines.append("   ");
				if (ccount < 9) {
					lines.append(" ");
				}
				lines.append(dec);
				lines.append("\n");
				ccount = 0;
			}
		}

		return lines.toString();
	}
}
