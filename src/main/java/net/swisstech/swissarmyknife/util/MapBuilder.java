package net.swisstech.swissarmyknife.util;

import java.util.HashMap;
import java.util.Map;

/**
 * fluent builder for maps
 * @since 1.1.4
 */
public class MapBuilder<K, V> {

	private final Map<K, V> map = new HashMap<>();

	public MapBuilder() {}

	public MapBuilder(K key, V value) {
		super();
		add(key, value);
	}

	public MapBuilder<K, V> add(K key, V value) {
		map.put(key, value);
		return this;
	}

	public Map<K, V> build() {
		return map;
	}
}
