package net.swisstech.swissarmyknife.lang;

import net.swisstech.swissarmyknife.test.PrivateConstructor;
import net.swisstech.swissarmyknife.util.Triple;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BinaryTest {

	@Test
	public void privateConstructor() throws IOException {
		PrivateConstructor.invoke(Binary.class);
	}

	@Test
	public void testPowerOfTwo() {
		assertTrue(Binary.isPowerOfTwo(0));
		assertTrue(Binary.isPowerOfTwo(1));
		assertTrue(Binary.isPowerOfTwo(2));
		assertFalse(Binary.isPowerOfTwo(3));
		assertTrue(Binary.isPowerOfTwo(4));
		assertFalse(Binary.isPowerOfTwo(5));

		assertFalse(Binary.isPowerOfTwo(7));
		assertTrue(Binary.isPowerOfTwo(8));
		assertFalse(Binary.isPowerOfTwo(9));

		assertFalse(Binary.isPowerOfTwo(15));
		assertTrue(Binary.isPowerOfTwo(16));
		assertFalse(Binary.isPowerOfTwo(17));

		assertFalse(Binary.isPowerOfTwo(31));
		assertTrue(Binary.isPowerOfTwo(32));
		assertFalse(Binary.isPowerOfTwo(33));

		assertFalse(Binary.isPowerOfTwo(63));
		assertTrue(Binary.isPowerOfTwo(64));
		assertFalse(Binary.isPowerOfTwo(65));

		assertFalse(Binary.isPowerOfTwo(127));
		assertTrue(Binary.isPowerOfTwo(128));
		assertFalse(Binary.isPowerOfTwo(129));

		assertFalse(Binary.isPowerOfTwo(255));
		assertTrue(Binary.isPowerOfTwo(256));
		assertFalse(Binary.isPowerOfTwo(257));

		assertFalse(Binary.isPowerOfTwo(511));
		assertTrue(Binary.isPowerOfTwo(512));
		assertFalse(Binary.isPowerOfTwo(513));

		assertFalse(Binary.isPowerOfTwo(1023));
		assertTrue(Binary.isPowerOfTwo(1024));
		assertFalse(Binary.isPowerOfTwo(1025));

		assertFalse(Binary.isPowerOfTwo(2047));
		assertTrue(Binary.isPowerOfTwo(2048));
		assertFalse(Binary.isPowerOfTwo(2049));

		assertFalse(Binary.isPowerOfTwo(4095));
		assertTrue(Binary.isPowerOfTwo(4096));
		assertFalse(Binary.isPowerOfTwo(4097));

		assertFalse(Binary.isPowerOfTwo(8191));
		assertTrue(Binary.isPowerOfTwo(8192));
		assertFalse(Binary.isPowerOfTwo(8193));
	}

	@Test
	public void testCountLeadingZeroes() {

		List<Triple<Integer, Integer, Integer>> tests = new ArrayList<>();
		tests.add(new Triple<>(0, 0, 8));
		tests.add(new Triple<>(1, 1, 7));
		tests.add(new Triple<>(2, 3, 6));
		tests.add(new Triple<>(4, 7, 5));
		tests.add(new Triple<>(8, 15, 4));
		tests.add(new Triple<>(16, 31, 3));
		tests.add(new Triple<>(32, 63, 2));
		tests.add(new Triple<>(64, 127, 1));
		tests.add(new Triple<>(128, 255, 0));

		for (Triple<Integer, Integer, Integer> t : tests) {
			for (int i = t.a; i <= t.b; i++) {
				Assert.assertEquals(
						Binary.countLeadingZeroes(new byte[]{(byte) (i & 0xFF)}),
						t.c.intValue(),
						"Triple: " + t.a + " " + t.b + " " + t.c
				);
			}
		}
	}
}
