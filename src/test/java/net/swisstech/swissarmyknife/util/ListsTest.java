package net.swisstech.swissarmyknife.util;

import static net.swisstech.swissarmyknife.test.Assert.assertInstanceOf;
import static net.swisstech.swissarmyknife.test.Assert.assertSize;
import static net.swisstech.swissarmyknife.util.Lists.addAll;
import static net.swisstech.swissarmyknife.util.Lists.newArrayList;
import static net.swisstech.swissarmyknife.util.Lists.newLinkedList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import net.swisstech.swissarmyknife.test.PrivateConstructor;

import org.testng.annotations.Test;

/** test the Lists */
public class ListsTest {

	@Test
	public void privateConstructor() throws IOException {
		PrivateConstructor.invoke(Lists.class);
	}

	@Test
	public void testNewArrayList() {
		List<String> list = newArrayList("a", "b", "c", "d", "e", "f");
		assertSize(list, 6);
		assertInstanceOf(ArrayList.class, list);
	}

	@Test
	public void testNewLinkedList() {
		List<String> list = newLinkedList("a", "b", "c", "d", "e", "f");
		assertSize(list, 6);
		assertInstanceOf(LinkedList.class, list);
	}

	@Test
	public void testAddAll() {
		List<String> list = new ArrayList<>();
		addAll(list, "a", "b", "c", "d", "e", "f");
		assertSize(list, 6);
	}
}
