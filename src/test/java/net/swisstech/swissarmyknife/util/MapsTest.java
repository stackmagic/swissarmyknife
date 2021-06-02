package net.swisstech.swissarmyknife.util;

import net.swisstech.swissarmyknife.test.PrivateConstructor;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class MapsTest {

    private static final Map<String, String> EMPTY = new HashMap<>();
    private static final Map<String, String> MAP = new MapBuilder<>("Hello", "World").build();

    @Test
    public void privateConstructor() throws IOException {
        PrivateConstructor.invoke(Maps.class);
    }

    @Test()
    public void emptyNull() {
        assertNull(Maps.empty(null));
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Expected map to be empty but it isn't")
    public void emptyNotEmpty() {
        Maps.empty(MAP);
    }

    @Test
    public void emptyEmpty() {
        assertSame(Maps.empty(EMPTY), EMPTY);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Expected map to not be empty but it is")
    public void notEmptyNull() {
        Maps.notEmpty(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Expected map to not be empty but it is")
    public void notEmptyEmpty() {
        Maps.notEmpty(EMPTY);
    }

    @Test
    public void notEmptyFilled() {
        assertSame(Maps.notEmpty(MAP), MAP);
    }

    @Test
    public void isNotEmptyNull() {
        //noinspection ConstantConditions
        assertFalse(Maps.isNotEmpty(null));
    }

    @Test
    public void isNotEmptyEmpty() {
        assertFalse(Maps.isNotEmpty(EMPTY));
    }

    @Test
    public void isNotEmptyFilled() {
        assertTrue(Maps.isNotEmpty(MAP));
    }

    @Test
    public void isEmptyNull() {
        //noinspection ConstantConditions
        assertTrue(Maps.isEmpty(null));
    }

    @Test
    public void isEmptyEmpty() {
        assertTrue(Maps.isEmpty(EMPTY));
    }

    @Test
    public void isEmptyFilled() {
        assertFalse(Maps.isEmpty(MAP));
    }
}
