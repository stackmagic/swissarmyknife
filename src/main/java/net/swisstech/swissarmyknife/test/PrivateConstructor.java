package net.swisstech.swissarmyknife.test;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * This utility invokes the private default constructor of a class so these won't show up as non-covered in unit test coverage reports and distract us.
 *
 * @since 1.1.4
 */
public final class PrivateConstructor {

    /** private constructor for utility class */
    private PrivateConstructor() {
    }

    public static void invoke(Class<?> clazz) throws IOException {
        try {
            Constructor<?> ctor = clazz.getDeclaredConstructor();
            if (!Modifier.isPrivate(ctor.getModifiers())) {
                throw new AssertionError("Expected Constructor to be private");
            }
            ctor.setAccessible(true);
            ctor.newInstance();
        } catch (Exception e) {
            throw new IOException("Unexpected Exception", e);
        }
    }
}
