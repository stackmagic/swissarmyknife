package net.swisstech.swissarmyknife.test;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;

import static net.swisstech.swissarmyknife.test.Assert.*;
import static net.swisstech.swissarmyknife.util.Lists.newArrayList;
import static net.swisstech.swissarmyknife.util.Sets.newHashSet;

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
        String[] array = new String[]{"a", "b", "c"};
        assertSize(array, 3);
        assertSize(Collections.emptyList(), 0);
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
        assertSize(Collections.emptyList(), 0);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testAssertSizeCollectionFail() {
        assertSize(Collections.emptyList(), 1);
    }

    @Test
    public void testAssertSizeMapOk() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        assertSize(map, 3);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testAssertSizeMapFail() {
        Map<String, Integer> map = new HashMap<>();
        assertSize(map, 1);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testAssertNotEmptyArrayWithEmptyArray() {
        assertNotEmpty(new String[0]);
    }

    @Test
    public void testAssertNotEmptyArrayWithNonEmptyArray() {
        assertNotEmpty(new String[]{"hello"});
    }

    @Test
    public void assertEmptyArrayWithEmptyArray() {
        assertEmpty(new String[0]);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void assertEmptyArrayWithFilledArray() {
        assertEmpty(new String[]{"not", "empty"});
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testAssertNotEmptyCollectionWithEmptyList() {
        assertNotEmpty(Collections.emptyList());
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testAssertNotEmptyCollectionWithEmptySet() {
        assertNotEmpty(Collections.emptySet());
    }

    @Test
    public void testAssertNotEmptyCollectionWithNonEmptyCollection() {
        assertNotEmpty(newHashSet("hello"));
        assertNotEmpty(newArrayList("hello"));
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void assertSameSizeArrayWithFirstArgNull() {
        //noinspection ConstantConditions
        assertSameSize((String[]) null, new Integer[0]);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void assertSameSizeArrayWithSecondArgNull() {
        //noinspection ConstantConditions
        assertSameSize(new String[0], (Integer[]) null);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void assertSameSizeArrayWithDifferingSizes() {
        assertSameSize(new String[]{"a"}, new Integer[]{1, 2});
    }

    @Test
    public void assertSameSizeArrayOk() {
        assertSameSize(new String[]{"a", "b"}, new String[]{"c", "d"});
        assertSameSize(new String[]{"a", "b"}, new Integer[]{1, 2});
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void assertSameSizeCollectionWithFirstArgNull() {
        //noinspection ConstantConditions
        assertSameSize((List<String>) null, new ArrayList<>());
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void assertSameSizeCollectionWithSecondArgNull() {
        //noinspection ConstantConditions
        assertSameSize(new ArrayList<String>(), (List<Integer>) null);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void assertSameSizeCollectionWithDifferingSizes() {
        assertSameSize(Collections.singletonList("a"), Arrays.asList(1, 2));
    }

    @Test
    public void assertSameSizeCollectionOk() {
        assertSameSize(Arrays.asList("a", "b"), Arrays.asList("c", "d"));
        assertSameSize(Arrays.asList("a", "b"), Arrays.asList(1, 2));
    }

    @Test
    public void assertEmptyCollectionWithEmptyCollection() {
        assertEmpty(Collections.emptyList());
        assertEmpty(Collections.emptySet());
    }

    @Test(expectedExceptions = AssertionError.class)
    public void assertEmptyCollectionWithFilledList() {
        List<String> collection = new ArrayList<>();
        collection.add("Test");
        assertEmpty(collection);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void assertEmptyCollectionWithFilledSet() {
        Set<String> collection = new HashSet<>();
        collection.add("Test");
        assertEmpty(collection);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testAssertNotEmptyMapWithEmptyMap() {
        assertNotEmpty(Collections.emptyMap());
    }

    @Test
    public void testAssertNotEmptyMapWithNonEmptyMap() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "b");
        assertNotEmpty(map);
    }

    @Test
    public void assertEmptyMapWithEmptyMap() {
        assertEmpty(Collections.emptyMap());
    }

    @Test(expectedExceptions = AssertionError.class)
    public void assertEmptyMapWithFilledMap() {
        Map<String, String> map = new HashMap<>();
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
        Set<String> set = new HashSet<>();
        set.add("asdf");
        assertCollectionContains(set, "asdf");
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = "Expected collection to contain element asdf but found 1 other elements")
    public void assertCollectionContains_setContainsNot() {
        Set<String> set = new HashSet<>();
        set.add("qwer");
        assertCollectionContains(set, "asdf");
    }

    @Test
    public void assertCollectionContains_listContains() {
        List<String> set = new ArrayList<>();
        set.add("asdf");
        assertCollectionContains(set, "asdf");
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = "Expected collection to contain element asdf but found 1 other elements")
    public void assertCollectionContains_listContainsNot() {
        List<String> set = new ArrayList<>();
        set.add("qwer");
        assertCollectionContains(set, "asdf");
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void assertCollectionContainsAllNullArg1() {
        //noinspection ConstantConditions
        assertCollectionContainsAll(null, null);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void assertCollectionContainsAllNullArg2() {
        assertCollectionContainsAll(new ArrayList<String>(), null);
    }

    @Test
    public void assertCollectionContainsAllOk() {
        List<String> all = Arrays.asList("a", "b", "c", "d");
        assertCollectionContainsAll(all, new ArrayList<String>());
        assertCollectionContainsAll(all, Collections.singletonList("a"));
        assertCollectionContainsAll(all, Collections.singletonList("b"));
        assertCollectionContainsAll(all, Collections.singletonList("c"));
        assertCollectionContainsAll(all, Collections.singletonList("d"));
        assertCollectionContainsAll(all, Arrays.asList("a", "c"));
        assertCollectionContainsAll(all, Arrays.asList("b", "d"));
    }

    @Test(expectedExceptions = AssertionError.class)
    public void assertCollectionContainsAllFail() {
        List<String> all = Arrays.asList("a", "b", "c", "d");
        assertCollectionContainsAll(all, Collections.singletonList("XXX"));
    }

    @Test(expectedExceptions = AssertionError.class)
    public void assertGreaterThanFail() {
        assertGreaterThan(5, 5);
    }

    @Test
    public void assertGreaterThanOk() {
        assertGreaterThan(5, 4);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void assertOneOfLongFail() {
        assertOneOf(1, 2, 3);
    }

    @Test
    public void assertOneOfOk() {
        assertOneOf(1, 2, 3, 1);
    }
}
