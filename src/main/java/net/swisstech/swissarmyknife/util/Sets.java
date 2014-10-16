package net.swisstech.swissarmyknife.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/** set utils we've been missing from guava and jdk standart apis */
public final class Sets {

	/** private constructor for utility class */
	private Sets() {}

	public static <T> Set<T> newHashSet(T... items) {
		Set<T> set = new HashSet<T>();
		return addAll(set, items);
	}

	public static <T> Set<T> newTreeSet(T... items) {
		Set<T> set = new TreeSet<T>();
		return addAll(set, items);
	}

	public static <T> Set<T> addAll(Set<T> set, T... items) {
		List<T> list = Arrays.asList(items);
		set.addAll(list);
		return set;
	}
}
