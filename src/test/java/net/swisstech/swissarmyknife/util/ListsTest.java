package net.swisstech.swissarmyknife.util;

import net.swisstech.swissarmyknife.test.PrivateConstructor;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static net.swisstech.swissarmyknife.test.Assert.assertInstanceOf;
import static net.swisstech.swissarmyknife.test.Assert.assertSize;

public class ListsTest {

    @Test
    public void privateConstructor() throws IOException {
        PrivateConstructor.invoke(Lists.class);
    }

    @Test
    public void testNewArrayList() {
        List<String> list = Lists.newArrayList("a", "b", "c", "d", "e", "f");
        assertSize(list, 6);
        assertInstanceOf(ArrayList.class, list);
    }

    @Test
    public void testNewLinkedList() {
        List<String> list = Lists.newLinkedList("a", "b", "c", "d", "e", "f");
        assertSize(list, 6);
        assertInstanceOf(LinkedList.class, list);
    }

    @Test
    public void testAddAll() {
        List<String> list = new ArrayList<>();
        Lists.addAll(list, "a", "b", "c", "d", "e", "f");
        assertSize(list, 6);
    }
}
