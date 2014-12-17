package net.swisstech.swissarmyknife.test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;
import static java.util.Collections.emptySet;
import static net.swisstech.swissarmyknife.test.Assert.assertCollectionContains;
import static net.swisstech.swissarmyknife.test.Assert.assertCollectionContainsAll;
import static net.swisstech.swissarmyknife.test.Assert.assertEmpty;
import static net.swisstech.swissarmyknife.test.Assert.assertGreaterThan;
import static net.swisstech.swissarmyknife.test.Assert.assertHammingDistanceLowerEqual;
import static net.swisstech.swissarmyknife.test.Assert.assertInstanceOf;
import static net.swisstech.swissarmyknife.test.Assert.assertNotEmpty;
import static net.swisstech.swissarmyknife.test.Assert.assertSize;
import static net.swisstech.swissarmyknife.test.Assert.assertSizeMin;
import static net.swisstech.swissarmyknife.test.Assert.assertSmallerThan;
import static net.swisstech.swissarmyknife.util.Lists.newArrayList;
import static net.swisstech.swissarmyknife.util.Sets.newHashSet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

public class AssertTest {

	@Test
	public void privateConstructor() throws IOException {
		PrivateConstructor.invoke(Assert.class);
	}

	@Test
	public void assertInstanceOfOk() {
		IOException ex = new IOException("testing");
		assertInstanceOf(Throwable.class, ex);
		assertInstanceOf(Exception.class, ex);
		assertInstanceOf(IOException.class, ex);
	}

	@Test(expectedExceptions = AssertionError.class)
	public void assertInstanceOfFail() {
		assertInstanceOf(IOException.class, new Exception("not an IOException"));
	}

	@Test
	public void testAssertSizeArrayOk() {
		String[] array = new String[]{ "a", "b", "c" };
		assertSize(array, 3);
		assertSize(emptyList(), 0);
	}

	@Test(expectedExceptions = AssertionError.class)
	public void testAssertSizeArrayFail() {
		assertSize(new String[0], 1);
	}

	@Test
	public void testAssertMinSizeCollectionOk() {
		List<Integer> list = Arrays.asList(1, 2, 3);
		assertSizeMin(list, 3);
	}

	@Test(expectedExceptions = AssertionError.class)
	public void testAssertMinSizeCollectionFail() {
		List<Integer> list = Arrays.asList(1, 2, 3);
		assertSizeMin(list, 4);
	}

	@Test
	public void testAssertSizeCollectionOk() {
		List<String> list = Arrays.asList("a", "b", "c");
		assertSize(list, 3);
		assertSize(emptyList(), 0);
	}

	@Test(expectedExceptions = AssertionError.class)
	public void testAssertSizeCollectionFail() {
		assertSize(emptyList(), 1);
	}

	@Test
	public void testAssertSizeMapOk() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		assertSize(map, 3);
	}

	@Test(expectedExceptions = AssertionError.class)
	public void testAssertSizeMapFail() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		assertSize(map, 1);
	}

	@Test(expectedExceptions = AssertionError.class)
	public void testAssertNotEmptyArrayWithEmptyArray() {
		assertNotEmpty(new String[0]);
	}

	@Test
	public void testAssertNotEmptyArrayWithNonEmptyArray() {
		assertNotEmpty(new String[]{ "hello" });
	}

	@Test
	public void assertEmptyArrayWithEmptyArray() {
		assertEmpty(new String[0]);
	}

	@Test(expectedExceptions = AssertionError.class)
	public void assertEmptyArrayWithFilledArray() {
		assertEmpty(new String[]{ "not", "empty" });
	}

	@Test(expectedExceptions = AssertionError.class)
	public void testAssertNotEmptyCollectionWithEmptyList() {
		assertNotEmpty(emptyList());
	}

	@Test(expectedExceptions = AssertionError.class)
	public void testAssertNotEmptyCollectionWithEmptySet() {
		assertNotEmpty(emptySet());
	}

	@Test
	public void testAssertNotEmptyCollectionWithNonEmptyCollection() {
		assertNotEmpty(newHashSet("hello"));
		assertNotEmpty(newArrayList("hello"));
	}

	@Test
	public void assertEmptyCollectionWithEmptyCollection() {
		assertEmpty(emptyList());
		assertEmpty(emptySet());
	}

	@Test(expectedExceptions = AssertionError.class)
	public void assertEmptyCollectionWithFilledList() {
		List<String> collection = new ArrayList<String>();
		collection.add("Test");
		assertEmpty(collection);
	}

	@Test(expectedExceptions = AssertionError.class)
	public void assertEmptyCollectionWithFilledSet() {
		Set<String> collection = new HashSet<String>();
		collection.add("Test");
		assertEmpty(collection);
	}

	@Test(expectedExceptions = AssertionError.class)
	public void testAssertNotEmptyMapWithEmptyMap() {
		assertNotEmpty(emptyMap());
	}

	@Test
	public void testAssertNotEmptyMapWithNonEmptyMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "b");
		assertNotEmpty(map);
	}

	@Test
	public void assertEmptyMapWithEmptyMap() {
		assertEmpty(emptyMap());
	}

	@Test(expectedExceptions = AssertionError.class)
	public void assertEmptyMapWithFilledMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "b");
		assertEmpty(map);
	}

	@Test(expectedExceptions = AssertionError.class)
	public void assertEmptyStringWithNull() {
		assertEmpty((String) null);
	}

	@Test
	public void assertEmptyOk() {
		assertEmpty("");
	}

	@Test
	public void assertSmallerOk() {
		assertSmallerThan(0, 0.0000000001);
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = "Excpected 0.000000 to be smaller than 0.000000")
	public void assertSmallerFail() {
		assertSmallerThan(0, 0);
	}

	@Test
	public void assertHammingDistanceLowerEqualOK() {
		assertHammingDistanceLowerEqual(3, 0, 2);
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = "Expected hamming distance of 3 and 0 to be smaller or equal 1, but is 2")
	public void assertHammingDistanceLowerEqualFail() {
		assertHammingDistanceLowerEqual(3, 0, 1);
	}

	@Test
	public void assertCollectionContains_setContains() {
		Set<String> set = new HashSet<String>();
		set.add("asdf");
		assertCollectionContains(set, "asdf");
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = "Expected collection to contain element asdf but found 1 other elements")
	public void assertCollectionContains_setContainsNot() {
		Set<String> set = new HashSet<String>();
		set.add("qwer");
		assertCollectionContains(set, "asdf");
	}

	@Test
	public void assertCollectionContains_listContains() {
		List<String> set = new ArrayList<String>();
		set.add("asdf");
		assertCollectionContains(set, "asdf");
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = "Expected collection to contain element asdf but found 1 other elements")
	public void assertCollectionContains_listContainsNot() {
		List<String> set = new ArrayList<String>();
		set.add("qwer");
		assertCollectionContains(set, "asdf");
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void assertCollectionContainsAllNullArg1() {
		assertCollectionContainsAll(null, null);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void assertCollectionContainsAllNullArg2() {
		assertCollectionContainsAll(new ArrayList<String>(), null);
	}

	@Test
	public void assertCollectionContainsAllOk() {
		List<String> all = asList("a", "b", "c", "d");
		assertCollectionContainsAll(all, new ArrayList<String>());
		assertCollectionContainsAll(all, asList("a"));
		assertCollectionContainsAll(all, asList("b"));
		assertCollectionContainsAll(all, asList("c"));
		assertCollectionContainsAll(all, asList("d"));
		assertCollectionContainsAll(all, asList("a", "c"));
		assertCollectionContainsAll(all, asList("b", "d"));
	}

	@Test(expectedExceptions = AssertionError.class)
	public void assertCollectionContainsAllFail() {
		List<String> all = asList("a", "b", "c", "d");
		assertCollectionContainsAll(all, asList("XXX"));
	}

	@Test(expectedExceptions = AssertionError.class)
	public void assertGreaterThanFail() {
		assertGreaterThan(5, 5);
	}

	public void assertGreaterThanOk() {
		assertGreaterThan(5, 4);
	}
}
