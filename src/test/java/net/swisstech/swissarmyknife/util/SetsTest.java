package net.swisstech.swissarmyknife.util;

import static net.swisstech.swissarmyknife.test.Assert.assertInstanceOf;
import static net.swisstech.swissarmyknife.test.Assert.assertSize;
import static net.swisstech.swissarmyknife.util.Sets.addAll;
import static net.swisstech.swissarmyknife.util.Sets.newHashSet;
import static net.swisstech.swissarmyknife.util.Sets.newTreeSet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import net.swisstech.swissarmyknife.test.PrivateConstructor;

import org.testng.annotations.Test;

/** Test the Sets */
public class SetsTest {

	@Test
	public void privateConstructor() throws IOException {
		PrivateConstructor.invoke(Sets.class);
	}

	@Test
	public void testNewHashSet() {
		Set<String> set = newHashSet("a", "b", "c", "a", "b", "c");
		assertSize(set, 3);
		assertInstanceOf(HashSet.class, set);
	}

	@Test
	public void testNewTreeSet() {
		Set<String> set = newTreeSet("a", "b", "c", "a", "b", "c");
		assertSize(set, 3);
		assertInstanceOf(TreeSet.class, set);
	}

	@Test
	public void testAddAll() {
		Set<String> set = new HashSet<>();
		addAll(set, "a", "b", "c", "a", "b", "c");
		assertSize(set, 3);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void notEmptyWithNull() {
		Sets.notEmpty(null);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void notEmptyWithEmpty() {
		Sets.notEmpty(new HashSet<>());
	}

	@Test
	public void notEmptyWithFilled() {
		Sets.notEmpty(newHashSet("a"));
	}
}
