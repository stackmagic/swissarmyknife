package net.swisstech.swissarmyknife.util;

import net.swisstech.swissarmyknife.test.PrivateConstructor;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static net.swisstech.swissarmyknife.test.Assert.*;
import static net.swisstech.swissarmyknife.util.Sets.*;
import static org.testng.Assert.assertNotNull;

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
    public void testNewHashSetWithNull() {
        Set<String> set = newHashSet((String[]) null);
        assertNotNull(set);
        assertEmpty(set);
    }

    @Test
    public void testNewHashSetWithEmpty() {
        Set<String> set = newHashSet();
        assertNotNull(set);
        assertEmpty(set);
    }

    @Test
    public void testNewTreeSet() {
        Set<String> set = newTreeSet("a", "b", "c", "a", "b", "c");
        assertSize(set, 3);
        assertInstanceOf(TreeSet.class, set);
    }

    @Test
    public void testNewTreeSetWithNull() {
        Set<String> set = newTreeSet((String[]) null);
        assertNotNull(set);
        assertEmpty(set);
    }

    @Test
    public void testNewTreeSetWithEmpty() {
        Set<String> set = newTreeSet();
        assertNotNull(set);
        assertEmpty(set);
    }

    @Test
    public void testAddAll() {
        Set<String> set = new HashSet<>();
        addAll(set, "a", "b", "c", "a", "b", "c");
        assertSize(set, 3);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testAddAllWithNullSet() {
        addAll(null, "a", "b");
    }

    @Test
    public void testAddAllWithNullValues() {
        Set<String> set = new HashSet<>();
        addAll(set);
        assertEmpty(set);
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
        Set<String> set = Sets.notEmpty(newHashSet("a"));
        assertCollectionContains(set, "a");
    }
}
