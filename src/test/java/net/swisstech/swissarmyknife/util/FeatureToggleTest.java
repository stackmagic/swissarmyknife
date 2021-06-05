package net.swisstech.swissarmyknife.util;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static net.swisstech.swissarmyknife.test.Assert.*;

public class FeatureToggleTest {

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test
    public void testSet() {
        Set<String> subject = new HashSet<>();
        FeatureToggle<Set<String>> featureToggle = new FeatureToggle<>(subject, Set.class);
        Set<String> proxy = featureToggle.getProxy();
        assertEmpty(featureToggle.getDisabledMethodNames());

        // stuff is enabled by default
        proxy.add("test");
        assertCollectionContains(subject, "test");

        // disable method
        featureToggle.disable("contains");
        assertSize(featureToggle.getDisabledMethodNames(), 1);
        subject.contains("test");
        try {
            proxy.contains("test");
        } catch (UnsupportedOperationException e) {
            // ok
        }

        // disable method
        featureToggle.disable("remove");
        assertSize(featureToggle.getDisabledMethodNames(), 2);
        try {
            proxy.remove("test");
        } catch (UnsupportedOperationException e) {
            // ok
        }

        // re-enable method
        assertCollectionContains(subject, "test");
        featureToggle.enable("remove");
        proxy.remove("test");
        assertEmpty(subject);
    }
}
