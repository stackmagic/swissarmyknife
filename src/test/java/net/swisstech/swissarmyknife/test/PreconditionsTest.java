package net.swisstech.swissarmyknife.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import org.testng.annotations.Test;

/** test the Preconditions */
public class PreconditionsTest {

	@Test
	public void privateConstructor() throws IOException {
		PrivateConstructor.invoke(Preconditions.class);
	}

	@Test
	public void ensureNotEmptyString() {
		assertEquals(Preconditions.ensureNotEmpty("x"), "x");
		assertEquals(Preconditions.ensureNotEmpty(" x"), " x");
		assertEquals(Preconditions.ensureNotEmpty("x "), "x ");
		assertEquals(Preconditions.ensureNotEmpty(" x "), " x ");

		String[] errors = new String[]{ null, "", " " };
		for (String string : errors) {
			try {
				Preconditions.ensureNotEmpty(string);
				fail("Should't reach this point");
			}
			catch (IllegalArgumentException e) {
				assertEquals("String shouldn't be empty but got " + string, e.getMessage());
			}
		}
	}

	@Test
	public void ensureNullOk() {
		Preconditions.ensureNull(null, "won't be used");
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "must be null")
	public void ensureNullException() {
		Preconditions.ensureNull(new Object(), "must be null");
	}

	@Test
	public void notNullOk() {
		Preconditions.notNull(new Object());
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Object must not be null")
	public void notNullException() {
		Preconditions.notNull(null);
	}

	@Test
	public void ensureNotNullOk() {
		Preconditions.ensureNotNull(new Object(), "won't be used");
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "must not be null")
	public void ensureNotNullException() {
		Preconditions.ensureNotNull(null, "must not be null");
	}

	@Test
	public void ensureTrueOk() {
		Preconditions.ensureTrue(true, "won't be used");
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "must be true")
	public void ensureTrueException() {
		Preconditions.ensureTrue(false, "must be true");
	}

	@Test
	public void ensureFalseOk() {
		Preconditions.ensureFalse(false, "won't be used");
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "must be false")
	public void ensureFalseException() {
		Preconditions.ensureFalse(true, "must be false");
	}

	@Test
	public void ensureEqualsByteOk() {
		Preconditions.ensureEquals((byte) 68, (byte) 68, "the message");
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "expected 69 but got 68: the message")
	public void ensureEqualsByteException() {
		Preconditions.ensureEquals((byte) 68, (byte) 69, "the message");
	}

	@Test
	public void ensureEqualsShortOk() {
		Preconditions.ensureEquals((short) 12, (short) 12, "the message");
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "expected 13 but got 12: the message")
	public void ensureEqualsShortException() {
		Preconditions.ensureEquals((short) 12, (short) 13, "the message");
	}

	@Test
	public void ensureEqualsIntOk() {
		Preconditions.ensureEquals(23456, 23456, "the message");
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "expected 23455 but got 23456: the message")
	public void ensureEqualsIntException() {
		Preconditions.ensureEquals(23456, 23455, "the message");
	}

	@Test
	public void ensureEqualsLongOk() {
		Preconditions.ensureEquals(123L, 123L, "the message");
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "expected 56 but got 55: the message")
	public void ensureEqualsLongException() {
		Preconditions.ensureEquals(55L, 56L, "the message");
	}

	@Test
	public void ensureEqualsFloatOk() {
		Preconditions.ensureEquals(1.23f, 1.23f, "the message");
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "expected 1.24 but got 1.23: the message")
	public void ensureEqualsFloatException() {
		Preconditions.ensureEquals(1.23f, 1.24f, "the message");
	}

	@Test
	public void ensureEqualsDoubleOk() {
		Preconditions.ensureEquals(1.23456d, 1.23456d, "the message");
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "expected 1.234555 but got 1.23456: the message")
	public void ensureEqualsDoubleException() {
		Preconditions.ensureEquals(1.23456d, 1.234555d, "the message");
	}

	@Test
	public void ensureEqualsCharOk() {
		Preconditions.ensureEquals('a', 'a', "the message");
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "expected b but got a: the message")
	public void ensureEqualsCharException() {
		Preconditions.ensureEquals('a', 'b', "the message");
	}

	@Test
	public void ensureEqualsBooleanOk() {
		Preconditions.ensureEquals(true, true, "the message");
		Preconditions.ensureEquals(false, false, "the message");
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "expected false but got true: the message")
	public void ensureEqualsBooleanException() {
		Preconditions.ensureEquals(true, false, "the message");
	}

	@Test
	public void ensureEqualsObjectOk() {
		Object o = new Object();
		Preconditions.ensureEquals(o, o, "the message");
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "the message")
	public void ensureEqualsObjectException() {
		Preconditions.ensureEquals(new Object(), new Object(), "the message");
	}

	@Test
	public static void ensureLowerThanOrEqualLongOk() {
		Preconditions.ensureLowerThanOrEqual(300, 300, "the message");
		Preconditions.ensureLowerThanOrEqual(299, 300, "the message");
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "the message")
	public static void ensureLowerThanOrEqualLongException() {
		Preconditions.ensureLowerThanOrEqual(301, 300, "the message");
	}

	@Test
	public static void ensureLowerThanLongOk() {
		Preconditions.ensureLowerThan(299, 300, "the message");
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "the message")
	public static void ensureLowerThanELongxception() {
		Preconditions.ensureLowerThan(300, 300, "the message");
	}

	@Test
	public static void ensureHigherThanLongOk() {
		Preconditions.ensureHigherThan(301, 300, "the message");
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "the message")
	public static void ensureHigherThanLongException() {
		Preconditions.ensureHigherThan(300, 300, "the message");
	}

	@Test
	public static void ensureHigherThanOrEqualLongOK() {
		Preconditions.ensureHigherThanOrEqual(300, 300, "the message");
		Preconditions.ensureHigherThanOrEqual(301, 300, "the message");
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public static void ensureHigherThanOrEqualDoubleErr() {
		Preconditions.ensureHigherThanOrEqual(0.9, 1.0, "the message");
	}

	@Test
	public static void ensureHigherThanOrEqualDoubleOk() {
		Preconditions.ensureHigherThanOrEqual(1.0, 1.0, "the message");
		Preconditions.ensureHigherThanOrEqual(1.1, 1.0, "the message");
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void ensureLowerThanOrEqualDoubleOkException() {
		Preconditions.ensureLowerThanOrEqual(1.1, 1.0, "the message");
	}

	@Test
	public void ensureLowerThanOrEqualDoubleOk() {
		Preconditions.ensureLowerThanOrEqual(1.0, 1.0, "the message");
		Preconditions.ensureLowerThanOrEqual(0.9, 1.0, "the message");
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void ensureLowerThanDoubleException() {
		Preconditions.ensureLowerThan(1.1, 1.0, "the message");
	}

	@Test
	public void ensureLowerThanDoubleOk() {
		Preconditions.ensureLowerThan(0.9, 1.0, "the message");
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void ensureHigherThanDoubleException() {
		Preconditions.ensureHigherThan(1.0, 1.0, "the message");
	}

	@Test
	public void ensureHigherThanDoubleOk() {
		Preconditions.ensureHigherThan(1.1, 1.0, "the message");
	}

	@Test
	public static void ensureBetweenIncludingOK() {
		Preconditions.ensureBetweenIncluding(0, 0, 0, "the message");
		Preconditions.ensureBetweenIncluding(0, 1, 0, "the message");
		Preconditions.ensureBetweenIncluding(0, 1, 1, "the message");
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "the message: over")
	public static void ensureBetweenIncludingOver() {
		Preconditions.ensureBetweenIncluding(0, 2, 3, "the message: over");
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "the message: under")
	public static void ensureBetweenIncludingUnder() {
		Preconditions.ensureBetweenIncluding(5, 6, 4, "the message: under");
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "the message")
	public static void ensureHigherThanOrEqualException() {
		Preconditions.ensureHigherThanOrEqual(299, 300, "the message");
	}

	@Test
	public void ensureNotEmptyOk() {
		ArrayList<String> collection = new ArrayList<String>();
		collection.add("Hello World");
		Preconditions.ensureNotEmpty(collection, "won't be used");
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "none shall be empty!")
	public void ensureNotEmptyException() {
		Preconditions.ensureNotEmpty(new ArrayList<String>(), "none shall be empty!");
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void ensureNotEmptyNull() {
		Preconditions.ensureNotEmpty(null, "won't be used");
	}

	@Test
	public void ensureEmptyOk() {
		Preconditions.ensureEmpty(new ArrayList<Integer>(), "won't be used");
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "none shall be full!")
	public void ensureEmptyException() {
		ArrayList<Integer> collection = new ArrayList<Integer>();
		collection.add(7);
		Preconditions.ensureEmpty(collection, "none shall be full!");
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void ensureEmptyNUll() {
		Preconditions.ensureEmpty(null, "won't be used");
	}

	@Test
	public void ensureSizeOk() {
		LinkedList<String> collection = new LinkedList<String>();
		collection.add("alli");
		collection.add("mini");
		collection.add("äntli");
		collection.add("schwümmed");
		collection.add("uf");
		collection.add("em");
		collection.add("see");
		Preconditions.ensureSize(collection, 7, "won't be used");
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "expected size was 2 but actual size was 3: doh!")
	public void ensureSizeExceptionTooLarge() {
		LinkedList<String> collection = new LinkedList<String>();
		collection.add("alli");
		collection.add("mini");
		collection.add("äntli");
		Preconditions.ensureSize(collection, 2, "doh!");
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "expected size was 3 but actual size was 2: i can haz cheezburger\\?")
	public void ensureSizeExceptionTooSmall() {
		LinkedList<Long> collection = new LinkedList<Long>();
		collection.add(Long.MIN_VALUE);
		collection.add(Long.MAX_VALUE);
		Preconditions.ensureSize(collection, 3, "i can haz cheezburger?");
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void ensureSizeNull() {
		Preconditions.ensureSize(null, -1, "won't be used");
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = ".*i am not an url.*")
	public void ensureUrlInvalidUrl() {
		Preconditions.ensureUrl("i am not an url");
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "String shouldn't be empty but got null")
	public void ensureUrlNull() {
		Preconditions.ensureUrl(null);
	}

	@Test
	public void ensureUrlOk() {
		Preconditions.ensureUrl("http://www.swisstech.net");
		Preconditions.ensureUrl("ftp://www.swisstech.net");
	}
}
