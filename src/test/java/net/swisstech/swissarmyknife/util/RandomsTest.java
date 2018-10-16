package net.swisstech.swissarmyknife.util;

import net.swisstech.swissarmyknife.lang.Integers;
import net.swisstech.swissarmyknife.test.PrivateConstructor;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * some utils for random numbers
 *
 * @since 1.2.0
 */
public class RandomsTest {

	@Test
	public void privateConstructor() throws IOException {
		PrivateConstructor.invoke(Randoms.class);
	}

	@Test(invocationCount = 1_000)
	public void nextIntInclusive() {
		int r = Randoms.nextIntInclusive(10, 20);
		Integers.inRangeInclusive(r, 10, 20);
	}
}
