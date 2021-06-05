package net.swisstech.swissarmyknife.util;

import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.TreeSet;

import static net.swisstech.swissarmyknife.test.Assert.assertCollectionContains;
import static net.swisstech.swissarmyknife.test.Assert.assertEmpty;
import static org.testng.Assert.*;

public class FeatureToggleTest {

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test
    public void testSet() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Set<String> subject = new TreeSet<>();
        FeatureToggle<Set<String>> featureToggle = new FeatureToggle<>(subject, FeatureToggle.MethodStatus.ENABLED, Set.class);
        Set<String> proxy = featureToggle.getProxy();

        assertTrue(featureToggle.isEnabled("contains"));
        assertFalse(featureToggle.isDisabled("contains"));

        // stuff is enabled by default
        proxy.add("test");
        assertCollectionContains(subject, "test");

        // disable method
        featureToggle.disable("contains");
        assertTrue(featureToggle.isDisabled("contains"));
        assertFalse(featureToggle.isEnabled("contains"));
        subject.contains("test");
        try {
            proxy.contains("test");
        } catch (UnsupportedOperationException e) {
            // ok
        }

        // disable method
        featureToggle.disable("remove");

        assertTrue(featureToggle.isDisabled("contains"));
        assertFalse(featureToggle.isEnabled("contains"));
        assertTrue(featureToggle.isDisabled("remove"));
        assertFalse(featureToggle.isEnabled("remove"));

        try {
            proxy.remove("test");
        } catch (UnsupportedOperationException e) {
            // ok
        }

        // check status another way
        assertEquals(featureToggle.getMethodStatuses().values().stream().filter(it -> it == FeatureToggle.MethodStatus.DISABLED).count(), 2);

        // re-enable method
        featureToggle.enableAll();

        assertTrue(proxy.contains("test"));
        proxy.remove("test");
        assertFalse(proxy.contains("test"));
        assertEmpty(subject);

        // disableAll
        featureToggle.disableAll();
        assertEquals(featureToggle.getMethodStatuses().values().stream().filter(it -> it == FeatureToggle.MethodStatus.ENABLED).count(), 0);
        assertEquals(featureToggle.getMethodStatuses().values().stream().filter(it -> it == FeatureToggle.MethodStatus.DISABLED).count(), featureToggle.getMethodStatuses().size());

        // set status of invalid method
        try {
            featureToggle.setStatus("blargh", FeatureToggle.MethodStatus.ENABLED);
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
}
