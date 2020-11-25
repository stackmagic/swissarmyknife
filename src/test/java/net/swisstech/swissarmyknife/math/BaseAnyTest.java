package net.swisstech.swissarmyknife.math;

import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Arrays.asList;
import static org.testng.Assert.assertEquals;

public class BaseAnyTest {

	private final static String CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ.-_~äöü!$;:^'?=)(/&%ç*\"+°§";
	private static final BaseAny baseAny = new BaseAny(CHARS);

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = ".*must be unique.*")
	public void validate() {
		new BaseAny("01234567899".toCharArray());
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Invalid character ' ', not found in symbol list")
	public void invalidCharacter() {
		baseAny.decode("hello world");
	}

	@Test
	public void encodeDecode() {
		double base = CHARS.length();
		System.out.println("BASE   = " + base);
		System.out.println("INT    = " + Integer.MAX_VALUE);
		System.out.println("LONG   = " + Long.MAX_VALUE);
		System.out.println("DOUBLE = " + Double.MAX_VALUE);
		System.out.println("");

		List<BigDecimal> values = asList(
				new BigDecimal(0d),
				new BigDecimal(1d),
				new BigDecimal(2d),

				new BigDecimal(base - 2d),
				new BigDecimal(base - 1d),
				new BigDecimal(base),
				new BigDecimal(base + 1d),
				new BigDecimal(base + 2d),

				new BigDecimal(2 * base - 2d),
				new BigDecimal(2 * base - 1d),
				new BigDecimal(2 * base),
				new BigDecimal(2 * base + 1d),
				new BigDecimal(2 * base + 2d),

				new BigDecimal(3 * base - 2d),
				new BigDecimal(3 * base - 1d),
				new BigDecimal(3 * base),
				new BigDecimal(3 * base + 1d),
				new BigDecimal(3 * base + 2d),

				new BigDecimal(128d),
				new BigDecimal(512d),
				new BigDecimal(1024d),

				new BigDecimal(Math.pow(2, 2) - 1d),
				new BigDecimal(Math.pow(2, 3) - 1d),
				new BigDecimal(Math.pow(2, 5) - 1d),
				new BigDecimal(Math.pow(2, 7) - 1d),
				new BigDecimal(Math.pow(2, 13) - 1d),
				new BigDecimal(Math.pow(2, 17) - 1d),
				new BigDecimal(Math.pow(2, 19) - 1d),
				new BigDecimal(Math.pow(2, 31) - 1d),
				new BigDecimal(Math.pow(2, 61) - 1d),

				new BigDecimal(new Long(Long.MAX_VALUE).doubleValue()),
				new BigDecimal(Double.MAX_VALUE / 16d),
				new BigDecimal(Double.MAX_VALUE / 8d),
				new BigDecimal(Double.MAX_VALUE / 4d),
				new BigDecimal(Double.MAX_VALUE / 2d),

				new BigDecimal(Double.MAX_VALUE)
		);

		for (BigDecimal value : values) {
			String enc = baseAny.encode(value);
			BigDecimal dec = baseAny.decode(enc);
//			System.out.println(String.format("%40.0f => %20s => %40.0f => OK = %b", value.doubleValue(), enc, dec.doubleValue(), value.equals(dec)));
//			System.out.println("v: " + value.toString());
//			System.out.println("d: " + dec.toString());
//			System.out.println("e: " + enc);
//			System.out.println();
			assertEquals(dec, value);
		}
	}
}
