package net.swisstech.swissarmyknife.util;

import java.util.Map;

/**
 * utilities to work with maps
 *
 * @since 1.1.4
 */
public final class Maps {

    /** private constructor for utility class */
    private Maps() {
    }

    /** @since 2.1.0 */
    public static <K, V> Map<K, V> empty(Map<K, V> map) {
        if (isNotEmpty(map)) {
            throw new IllegalArgumentException("Expected map to be empty but it isn't");
        }

        return map;
    }

    /** @since 2.1.0 */
    public static <K, V> Map<K, V> notEmpty(Map<K, V> map) {
        if (isEmpty(map)) {
            throw new IllegalArgumentException("Expected map to not be empty but it is");
        }

        return map;
    }

    /** @since 2.1.0 */
    public static <K, V> boolean isNotEmpty(Map<K, V> map) {
        return !isEmpty(map);
    }

    public static <K, V> boolean isEmpty(Map<K, V> map) {
        return map == null || map.isEmpty();
    }
}
