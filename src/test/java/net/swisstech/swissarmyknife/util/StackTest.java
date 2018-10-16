package net.swisstech.swissarmyknife.util;

import org.testng.annotations.Test;

import java.util.NoSuchElementException;

import static org.testng.Assert.*;

public class StackTest {

	@Test
	public void test() {
		Stack<String> s = new Stack<>();
		assertNull(s.peek());
		assertEquals(s.size(), 0);
		try {
			s.pop();
			fail();
		} catch (NoSuchElementException e) {
		}

		s.push(null);
		assertEquals(s.size(), 1);
		assertNull(s.pop());
		assertEquals(s.size(), 0);

		s.push("hello");
		assertEquals(s.size(), 1);
		assertEquals(s.peek(), "hello");

		s.push("world");
		assertEquals(s.size(), 2);
		assertEquals(s.peek(), "world");
		assertEquals(s.pop(), "world");
		assertEquals(s.size(), 1);

		assertEquals(s.peek(), "hello");
		assertEquals(s.pop(), "hello");
		assertEquals(s.size(), 0);

		assertNull(s.peek());
		try {
			s.pop();
			fail();
		} catch (NoSuchElementException e) {
		}
	}
}
