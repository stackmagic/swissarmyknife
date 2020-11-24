package net.swisstech.swissarmyknife.math;

import static java.util.Arrays.asList;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.Test;

/** test the BaseAny */
public class BaseAnyTest {

	private final static String CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ.-_~äöü!$;:^'?=)(/&%ç*\"+";

	@Test
	public void testEncodeDecode() {

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
			String enc = be.encode(dbase, value);
			Double dec = be.decode(dbase, enc);
			System.out.println(String.format("%40.0f => %20s => %40.0f => OK = %b", value, enc, dec, value.equals(dec)));
			assertEquals(value, dec);
		}
	}
}
