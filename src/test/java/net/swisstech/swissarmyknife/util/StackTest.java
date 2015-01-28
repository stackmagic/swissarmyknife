package net.swisstech.swissarmyknife.util;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.fail;

import java.util.NoSuchElementException;

import org.testng.annotations.Test;

public class StackTest {

	@Test
	public void test() {
		Stack<String> s = new Stack<>();
		assertNull(s.peek());
		try {
			s.pop();
			fail();
		}
		catch (NoSuchElementException e) {}

		s.push(null);
		assertNull(s.pop());

		s.push("hello");
		assertEquals(s.peek(), "hello");

		s.push("world");
		assertEquals(s.peek(), "world");
		assertEquals(s.pop(), "world");

		assertEquals(s.peek(), "hello");
		assertEquals(s.pop(), "hello");

		assertNull(s.peek());
		try {
			s.pop();
			fail();
		}
		catch (NoSuchElementException e) {}
	}
}
