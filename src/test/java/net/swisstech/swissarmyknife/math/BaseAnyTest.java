package net.swisstech.swissarmyknife.math;

import org.testng.annotations.Test;

import java.math.BigInteger;
import java.util.List;

import static java.util.Arrays.asList;
import static org.testng.Assert.assertEquals;

public class BaseAnyTest {

    private final static String CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ.-_~äöü!$;:^'?=)(/&%ç*\"+°§";
    private static final BaseAny baseAny = new BaseAny(CHARS);

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = ".*must be unique.*")
    public void validate() {
        new BaseAny("01234567899".toCharArray());
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Invalid character ' ', not found in symbol list")
    public void invalidCharacter() {
        baseAny.decode("hello world");
    }

    @Test
    public void encodeDecode() {
        long base = CHARS.length();
        System.out.println("BASE   = " + base);
        System.out.println("INT    = " + Integer.MAX_VALUE);
        System.out.println("LONG   = " + Long.MAX_VALUE);
        System.out.println("DOUBLE = " + Double.MAX_VALUE);
        System.out.println("");

        List<BigInteger> values = asList(
                BigInteger.valueOf(0),
                BigInteger.valueOf(1),
                BigInteger.valueOf(2),

                BigInteger.valueOf(base - 2),
                BigInteger.valueOf(base - 1),
                BigInteger.valueOf(base),
                BigInteger.valueOf(base + 1),
                BigInteger.valueOf(base + 2),

                BigInteger.valueOf(2 * base - 2),
                BigInteger.valueOf(2 * base - 1),
                BigInteger.valueOf(2 * base),
                BigInteger.valueOf(2 * base + 1),
                BigInteger.valueOf(2 * base + 2),

                BigInteger.valueOf(3 * base - 2),
                BigInteger.valueOf(3 * base - 1),
                BigInteger.valueOf(3 * base),
                BigInteger.valueOf(3 * base + 1),
                BigInteger.valueOf(3 * base + 2),

                BigInteger.valueOf(128),
                BigInteger.valueOf(512),
                BigInteger.valueOf(1024),

                BigInteger.valueOf((long) Math.pow(2, 2) - 1),
                BigInteger.valueOf((long) Math.pow(2, 3) - 1),
                BigInteger.valueOf((long) Math.pow(2, 5) - 1),
                BigInteger.valueOf((long) Math.pow(2, 7) - 1),
                BigInteger.valueOf((long) Math.pow(2, 13) - 1),
                BigInteger.valueOf((long) Math.pow(2, 17) - 1),
                BigInteger.valueOf((long) Math.pow(2, 19) - 1),
                BigInteger.valueOf((long) Math.pow(2, 31) - 1),
                BigInteger.valueOf((long) Math.pow(2, 61) - 1),

                BigInteger.valueOf(Long.MAX_VALUE)
        );

        for (BigInteger value : values) {
            String enc = baseAny.encode(value);
            BigInteger dec = baseAny.decode(enc);
            //            			System.out.println(String.format("%40.0f => %20s => %40.0f => OK = %b", value.doubleValue(), enc, dec.doubleValue(), value.equals(dec)));
            //			System.out.println("v: " + value.toString());
            //			System.out.println("d: " + dec.toString());
            //			System.out.println("e: " + enc);
            //			System.out.println();
            assertEquals(dec, value);
        }
    }
}
