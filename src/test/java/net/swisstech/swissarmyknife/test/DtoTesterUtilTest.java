package net.swisstech.swissarmyknife.test;

import org.testng.annotations.Test;

import java.io.IOException;

public class DtoTesterUtilTest {

    // I think testng messes with us when we use mockito to throw all the exceptions
    // that are caught in the DtoTesterUtil so we don't test that stuff here.

    @Test
    public void privateConstructor() throws IOException {
        PrivateConstructor.invoke(DtoTesterUtil.class);
    }

    @Test
    public void testNull() throws IOException {
        DtoTesterUtil.testAllProperties(null);
    }

    @Test
    public void testDummy() throws IOException {
        DtoTesterUtil.testAllProperties(new Dummy());
    }

    public static class Dummy {

        private int a;
        private int b;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setC(int c) {
        }
    }
}
