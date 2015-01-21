package net.swisstech.swissarmyknife.util;

import static net.swisstech.swissarmyknife.test.Assert.assertSize;
import static org.testng.Assert.fail;

import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;

/** test the FeatureToggleSet */
public class FeatureToggleSetTest {

	// TODO test it all, or generate the code or test with reflection

	@Test
	public void testAdd() {
		Set<String> set = new HashSet<>();
		FeatureToggleSet<String> fts = new FeatureToggleSet<>(set);

		fts.add("A");
		assertSize(set, 1);
		assertSize(fts, 1);

		fts.disableAdd();
		try {
			fts.add("B");
			fail("Must not succeed!");
		}
		catch (UnsupportedOperationException e) {
			// all good
		}
		assertSize(set, 1);
		assertSize(fts, 1);

		fts.enable();
		fts.add("C");
		assertSize(set, 2);
		assertSize(fts, 2);

		fts.disable();
		try {
			fts.add("D");
			fail("Must not succeed!");
		}
		catch (UnsupportedOperationException e) {
			// all good
		}

		assertSize(set, 2);
		try {
			assertSize(fts, 2);
		}
		catch (UnsupportedOperationException e) {
			// all good
		}

		fts.enableSize();
		assertSize(fts, 2);
	}
}
