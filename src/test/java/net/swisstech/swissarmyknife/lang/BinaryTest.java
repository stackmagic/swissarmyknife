package net.swisstech.swissarmyknife.lang;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import net.swisstech.swissarmyknife.test.PrivateConstructor;

import org.testng.annotations.Test;

/** test the Binary */
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
}
