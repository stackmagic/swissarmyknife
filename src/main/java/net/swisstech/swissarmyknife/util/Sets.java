package net.swisstech.swissarmyknife.util;

import java.util.*;

/**
 * set utils we've been missing from guava and jdk standart apis
 *
 * @since 1.1.4
 */
public final class Sets {

    /**
     * private constructor for utility class
     */
    private Sets() {
    }

    @SafeVarargs
    public static <T> Set<T> newHashSet(T... items) {
        Set<T> set = new HashSet<>();
        return addAll(set, items);
    }

    @SafeVarargs
    public static <T> Set<T> newTreeSet(T... items) {
        //noinspection SortedCollectionWithNonComparableKeys
        Set<T> set = new TreeSet<>();
        return addAll(set, items);
    }

    @SafeVarargs
    public static <T> Set<T> addAll(Set<T> set, T... items) {
        if (items == null) {
            return set;
        }
        List<T> list = Arrays.asList(items);
        set.addAll(list);
        return set;
    }

    public static <T> Set<T> notEmpty(Set<T> set) {
        if (set == null || set.size() < 1) {
            throw new IllegalArgumentException("Set shouldn't be null/empty");
        }
        return set;
    }
}
