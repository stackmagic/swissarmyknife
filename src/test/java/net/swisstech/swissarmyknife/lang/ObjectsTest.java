package net.swisstech.swissarmyknife.lang;

import net.swisstech.swissarmyknife.test.PrivateConstructor;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertSame;

public class ObjectsTest {

    @Test
    public void privateConstructor() throws IOException {
        PrivateConstructor.invoke(Objects.class);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Object '' must not be null")
    public void notNullNull() {
        Objects.notNull(null);
    }

    @Test
    public void notNull() {
        Object o = new Object();
        assertSame(Objects.notNull(o), o);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Object 'test' must not be null")
    public void notNullNameNull() {
        Objects.notNull(null, "test");
    }

    @Test
    public void notNullName() {
        Object o = new Object();
        assertSame(Objects.notNull(o, "hello"), o);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Object 'hello' must not be null")
    public void notNullNullName() {
        Objects.notNull(null, "hello");
    }

    @Test
    public void valueOfDefault() {
        String x = "hello test";
        assertSame(Objects.valueOrDefault(null, x), x);
        assertSame(Objects.valueOrDefault(x, null), x);
        assertSame(Objects.valueOrDefault(x, "nope"), x);
    }
}
