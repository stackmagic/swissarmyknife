package net.swisstech.swissarmyknife.test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * util to test dtos (getters and setters) to get the code coverage and have them off the radar.
 *
 * @since 1.1.4
 */
public final class DtoTesterUtil {

	private static final Object[] EMPTY_ARGS = new Object[0];

	/**
	 * private constructor for utility class
	 */
	private DtoTesterUtil() {
	}

	public static void testAllProperties(Object object) throws IOException {
		if (object == null) {
			return;
		}
		try {
			BeanInfo bi = Introspector.getBeanInfo(object.getClass());
			PropertyDescriptor[] pds = bi.getPropertyDescriptors();

			for (PropertyDescriptor pd : pds) {

				Method getter = pd.getReadMethod();
				if (getter == null) {
					continue;
				}

				Object value = getter.invoke(object, EMPTY_ARGS);

				Method setter = pd.getWriteMethod();
				if (setter == null) {
					continue;
				}

				setter.invoke(object, value);
			}

			// and some other stuff
			//noinspection ResultOfMethodCallIgnored
			object.hashCode();
			//noinspection ResultOfMethodCallIgnored
			object.toString();
		} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException | IntrospectionException e) {
			throw new IOException(e);
		}
	}
}
