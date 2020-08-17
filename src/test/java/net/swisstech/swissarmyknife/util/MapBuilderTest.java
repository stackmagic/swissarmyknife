package net.swisstech.swissarmyknife.util;

import org.testng.annotations.Test;

import java.util.Map;

import static net.swisstech.swissarmyknife.test.Assert.assertEmpty;
import static net.swisstech.swissarmyknife.test.Assert.assertSize;

public class MapBuilderTest {

	@Test
	public void test() {
		Map<String, Integer> map = new MapBuilder<String, Integer>().build();
		assertEmpty(map);

		map = new MapBuilder<String, Integer>("hello", 1337).build();
		assertSize(map, 1);

		map = new MapBuilder<String, Integer>() //
				.add("a", 1) //
				.add("b", 2) //
				.add("c", 3) //
				.add("a", 1) //
				.add("b", 2) //
				.add("c", 3) //
				.build();
		assertSize(map, 3);
	}
}
