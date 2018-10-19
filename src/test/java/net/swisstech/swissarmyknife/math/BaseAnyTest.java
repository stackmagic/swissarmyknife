package net.swisstech.swissarmyknife.math;

import org.testng.annotations.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.testng.Assert.assertEquals;

public class BaseAnyTest {

	private final static String CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ.-_~äöü!$;:^'?=)(/&%ç*\"+°§";

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = ".*must be unique.*")
	public void validate() {
		new BaseAny("01234567899".toCharArray());
	}

	@Test
	public void encodeDecode() {

		BaseAny be = new BaseAny(CHARS);

		double dbase = CHARS.length();
		System.out.println("BASE   = " + dbase);
		System.out.println("INT    = " + Integer.MAX_VALUE);
		System.out.println("LONG   = " + Long.MAX_VALUE);
		System.out.println("DOUBLE = " + Double.MAX_VALUE);
		System.out.println("");

		List<Double> values = asList( //
				0d, //
				1d, //
				2d, //
				dbase - 2d, //
				dbase - 1d, //
				dbase, //
				dbase + 1d, //
				dbase + 2d, //
				128d, //
				512d, //
				1024d, //
				Math.pow(2, 2) - 1d, //
				Math.pow(2, 3) - 1d, //
				Math.pow(2, 5) - 1d, //
				Math.pow(2, 7) - 1d, //
				Math.pow(2, 13) - 1d, //
				Math.pow(2, 17) - 1d, //
				Math.pow(2, 19) - 1d, //
				Math.pow(2, 31) - 1d, // next mersenne prime (2^61-1 is out of range)
				new Long(Long.MAX_VALUE).doubleValue()
				// Double.MAX_VALUE ends up being 'Infinity'
		);

		for (Double value : values) {
			String enc = be.encode(value);
			double dec = be.decode(enc);
			System.out.println(String.format("%40.0f => %20s => %40.0f => OK = %b", value, enc, dec, value.equals(dec)));
			assertEquals(value, dec);
		}
	}
}
