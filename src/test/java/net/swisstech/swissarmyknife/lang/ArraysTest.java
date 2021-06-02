package net.swisstech.swissarmyknife.lang;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArraysTest {

    @Test
    public void testToInt() {
        byte[] bytes = new byte[]{0, 1, 127, -128, -127, -2, -1};

        int[] ints = Arrays.toInt(bytes);
        int[] expected = new int[]{0, 1, 127, 128, 129, 254, 255};

        assertEquals(ints, expected);
    }
}
