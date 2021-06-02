package net.swisstech.swissarmyknife.net;

import net.swisstech.swissarmyknife.test.PrivateConstructor;
import org.testng.annotations.Test;

import java.io.IOException;

public class IPTest {

    @Test
    public void privateConstructor() throws IOException {
        PrivateConstructor.invoke(IP.class);
    }
}
