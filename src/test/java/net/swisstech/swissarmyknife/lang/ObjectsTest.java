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

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void notNullNull() {
        Objects.notNull((Object) null);
    }

    @Test
    public void notNull() {
        Object o = new Object();
        assertSame(Objects.notNull(o), o);
    }

    @Test
    public void valueOfDefault() {
        String x = "hello test";
        assertSame(Objects.valueOrDefault(null, x), x);
        assertSame(Objects.valueOrDefault(x, null), x);
        assertSame(Objects.valueOrDefault(x, "nope"), x);
    }
}
