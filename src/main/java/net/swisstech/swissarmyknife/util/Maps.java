package net.swisstech.swissarmyknife.util;

import java.util.Map;

/** utilities to work with maps */
public final class Maps {

	/** private constructor for utility class */
	private Maps() {}

	public static <K, V> boolean isEmpty(Map<K, V> map) {
		return map == null || map.isEmpty();
	}
}
