package net.swisstech.swissarmyknife.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Disable the ability to call certain methods. By default, all methods are
 * permitted and need to be disabled by calling disable(methodName).
 *
 * todo verify the passed class objects are actually interfaces and enumerate all
 *  methods in a Map<MethodName, EnabledDisabledStatus> so we can do things like
 *  enableAll/disableAll
 *
 * @param <T> Type of the wrapped object
 */
public class FeatureToggle<T> {

    /** proxy/wrapper on which we intercept calls */
    private final T proxy;

    /** set of disabled methods */
    private final Set<String> disabledMethodNames = new HashSet<>();

    /**
     * @param instance       The object to wrap/protect - retrieve the proxy for it by calling getProxy()
     * @param interfaceClass The interface Class for which we will create the proxy
     */
    public FeatureToggle(T instance, Class<? super T> interfaceClass) {
        //noinspection unchecked
        this(instance, new Class[]{interfaceClass});
    }

    /**
     * @param instance         The object to wrap/protect - retrieve the proxy for it by calling getProxy()
     * @param interfaceClasses The interface Classes for which we will create the proxy
     */
    public FeatureToggle(T instance, Class<? super T>[] interfaceClasses) {
        //noinspection unchecked
        this.proxy = (T) Proxy.newProxyInstance(
                FeatureToggle.class.getClassLoader(),
                interfaceClasses,
                new FeatureToggleInvocationHandler(instance, disabledMethodNames)
        );
    }

    public T getProxy() {
        return proxy;
    }

    public Set<String> getDisabledMethodNames() {
        return Collections.unmodifiableSet(disabledMethodNames);
    }

    public void enable(String methodName) {
        disabledMethodNames.remove(methodName);
    }

    public void disable(String methodName) {
        disabledMethodNames.add(methodName);
    }

    /** inner class so one can't use "FeatureToggle.invoke" */
    private static class FeatureToggleInvocationHandler implements InvocationHandler {

        private final Object instance;
        private final Set<String> disabledMethodNames;

        public FeatureToggleInvocationHandler(Object instance, Set<String> disabledMethodNames) {
            this.instance = instance;
            this.disabledMethodNames = disabledMethodNames;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            String methodName = method.getName();
            boolean isMethodDisabled = disabledMethodNames.contains(methodName);

            if (isMethodDisabled) {
                throw new UnsupportedOperationException("Calling of " + methodName + " is disabled");
            }

            return method.invoke(instance, args);
        }
    }
}
