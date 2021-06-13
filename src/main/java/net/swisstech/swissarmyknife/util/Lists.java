package net.swisstech.swissarmyknife.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

/**
 * list utils we've been missing from guava and jdk standart apis
 *
 * @since 1.1.7
 */
public class Lists {

    /**
     * private constructor for utility class
     */
    private Lists() {
    }

    @SafeVarargs
    public static <T> List<T> newArrayList(T... items) {
        return addAll(new ArrayList<>(), items);
    }

    @SafeVarargs
    public static <T> List<T> newLinkedList(T... items) {
        return addAll(new LinkedList<>(), items);
    }

    @SafeVarargs
    public static <T> List<T> newList(Supplier<List<T>> ctor, T... items) {
        return addAll(ctor.get(), items);
    }

    @SafeVarargs
    public static <T> List<T> addAll(List<T> list, T... items) {
        list.addAll(Arrays.asList(items));
        return list;
    }
}
