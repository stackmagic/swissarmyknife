package net.swisstech.swissarmyknife.net;

import static net.swisstech.swissarmyknife.lang.Integers.inRangeInclusive;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import net.swisstech.swissarmyknife.test.PrivateConstructor;

import org.testng.annotations.Test;

public class TCPTest {

	@Test
	public void privateConstructor() throws IOException {
		PrivateConstructor.invoke(TCP.class);
	}

	@Test(invocationCount = 1000)
	public void randomUnprivilegedPort() {
		inRangeInclusive(TCP.getRandomUnprivilegedPort(), 0, 65535);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void validPortNumberLo() {
		TCP.validPortNumber(-1);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void validPortNumberHi() {
		TCP.validPortNumber(65536);
	}

	@Test
	public void validPortNumber() {
		TCP.validPortNumber(0);
		TCP.validPortNumber(65535);
	}

	@Test
	public void isValidPortNumber() {
		assertFalse(TCP.isValidPortNumber(-1));
		assertTrue(TCP.isValidPortNumber(0));
		assertTrue(TCP.isValidPortNumber(65535));
		assertFalse(TCP.isValidPortNumber(65536));
	}
}
