package net.swisstech.swissarmyknife.util;

import java.util.Deque;
import java.util.LinkedList;

/** simple non-vector based stack, allows null values */
public class Stack<T> {

	private final Deque<T> elements = new LinkedList<>();

	public T peek() {
		return elements.peekFirst();
	}

	public T pop() {
		return elements.removeFirst();
	}

	public void push(T element) {
		elements.offerFirst(element);
	}

	public int size() {
		return elements.size();
	}
}
