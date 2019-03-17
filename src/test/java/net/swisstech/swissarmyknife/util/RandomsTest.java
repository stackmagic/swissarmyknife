package net.swisstech.swissarmyknife.util;

import com.sun.crypto.provider.SunJCE;
import net.swisstech.swissarmyknife.lang.Doubles;
import net.swisstech.swissarmyknife.lang.Floats;
import net.swisstech.swissarmyknife.lang.Integers;
import net.swisstech.swissarmyknife.lang.Longs;
import org.testng.annotations.Test;

import java.security.SecureRandomSpi;

/**
 * some utils for random numbers
 *
 * @since 1.2.0
 */
public class RandomsTest {

	private static Randoms RANDOMS = new Randoms();

	@Test
	public void create() {
		new Randoms();
		new Randoms("hello".getBytes());
		new Randoms(new SecureRandomSpi() {
			@Override
			protected void engineSetSeed(byte[] bytes) {
			}

			@Override
			protected void engineNextBytes(byte[] bytes) {
			}

			@Override
			protected byte[] engineGenerateSeed(int i) {
				return new byte[0];
			}
		}, new SunJCE());
	}

	@Test(invocationCount = 100)
	public void nextIntInclusiveHighRange() {
		int lo = Integer.MAX_VALUE - 84_848_484;
		int hi = Integer.MAX_VALUE - 42_424_242;
		int r = RANDOMS.nextIntInclusive(lo, hi);
		Integers.inRangeInclusive(r, lo, hi);
	}

	@Test(invocationCount = 100)
	public void nextIntInclusiveLowRange() {
		int lo = Integer.MIN_VALUE + 42_424_242;
		int hi = Integer.MIN_VALUE + 84_848_484;
		int r = RANDOMS.nextIntInclusive(lo, hi);
		Integers.inRangeInclusive(r, lo, hi);
	}

	@Test(invocationCount = 100)
	public void nextIntInclusiveMixedRange() {
		int lo = -42_424_242;
		int hi = +42_424_242;
		int r = RANDOMS.nextIntInclusive(lo, hi);
		Integers.inRangeInclusive(r, lo, hi);
	}

	@Test(invocationCount = 100)
	public void nextDoubleInclusiveHighRange() {
		double lo = Double.MAX_VALUE - 9_000_000;
		double hi = Double.MAX_VALUE - 1_000_000;
		double r = RANDOMS.nextDoubleInclusive(lo, hi);
		Doubles.inRangeInclusive(r, lo, hi);
	}

	@Test(invocationCount = 100)
	public void nextDoubleInclusiveLowRange() {
		double lo = Double.MIN_VALUE + 1_000_000;
		double hi = Double.MIN_VALUE + 9_000_000;
		double r = RANDOMS.nextDoubleInclusive(lo, hi);
		Doubles.inRangeInclusive(r, lo, hi);
	}

	@Test(invocationCount = 100)
	public void nextDoubleInclusiveMixedRange() {
		double lo = -9_000_000;
		double hi = +9_000_000;
		double r = RANDOMS.nextDoubleInclusive(lo, hi);
		Doubles.inRangeInclusive(r, lo, hi);
	}

	@Test(invocationCount = 100)
	public void nextLongInclusiveHighRange() {
		long lo = Long.MAX_VALUE - 9999999999L;
		long hi = Long.MAX_VALUE - 1111111111L;
		long r = RANDOMS.nextLongInclusive(lo, hi);
		Longs.inRangeInclusive(r, lo, hi);
	}

	@Test(invocationCount = 100)
	public void nextLongInclusiveLowRange() {
		long lo = Long.MIN_VALUE + 1111111111L;
		long hi = Long.MIN_VALUE + 9999999999L;
		long r = RANDOMS.nextLongInclusive(lo, hi);
		Longs.inRangeInclusive(r, lo, hi);
	}

	@Test(invocationCount = 100)
	public void nextLongInclusiveMixedRange() {
		long lo = -9999999999L;
		long hi = +9999999999L;
		long r = RANDOMS.nextLongInclusive(lo, hi);
		Longs.inRangeInclusive(r, lo, hi);
	}

	@Test(invocationCount = 100)
	public void nextFloatInclusiveHighRange() {
		float lo = Float.MAX_VALUE - 9_876_543;
		float hi = Float.MAX_VALUE - 1_234_567;
		float r = RANDOMS.nextFloatInclusive(lo, hi);
		Floats.inRangeInclusive(r, lo, hi);
	}

	@Test(invocationCount = 100)
	public void nextFloatInclusiveLowRange() {
		float lo = Float.MIN_VALUE + 1_234_567;
		float hi = Float.MIN_VALUE + 9_876_543;
		float r = RANDOMS.nextFloatInclusive(lo, hi);
		Floats.inRangeInclusive(r, lo, hi);
	}

	@Test(invocationCount = 100)
	public void nextFloatInclusiveMixedRange() {
		float lo = -9_876_543;
		float hi = +9_876_543;
		float r = RANDOMS.nextFloatInclusive(lo, hi);
		Floats.inRangeInclusive(r, lo, hi);
	}
}
