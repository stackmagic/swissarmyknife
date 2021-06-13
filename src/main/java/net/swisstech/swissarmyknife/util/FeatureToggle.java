package net.swisstech.swissarmyknife.util;

import net.swisstech.swissarmyknife.test.Preconditions;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Disable the ability to call certain methods. By default, all methods are
 * permitted and need to be disabled by calling disable(methodName).
 *
 * @param <T> Type of the wrapped object
 */
public class FeatureToggle<T> {

    /** proxy/wrapper on which we intercept calls */
    private final T proxy;

    /** enable/disable state of the methods */
    private final Map<String, MethodStatus> methods = new HashMap<>();

    /** string representation of proxies interfaces */
    private final String interfacesString;

    /**
     * @param instance       The object to wrap/protect - retrieve the proxy for it by calling getProxy()
     * @param interfaceClass The interface Class for which we will create the proxy
     * @param defaultStatus  defaultStatus for methods (enabled/disabled)
     */
    @SuppressWarnings("unchecked")
    public FeatureToggle(T instance, MethodStatus defaultStatus, Class<? super T> interfaceClass) {
        this(instance, defaultStatus, new Class[]{interfaceClass});
    }

    /**
     * @param instance      The object to wrap/protect - retrieve the proxy for it by calling getProxy()
     * @param interfaces    The interface Classes for which we will create the proxy
     * @param defaultStatus defaultStatus for methods (enabled/disabled)
     */
    @SuppressWarnings("unchecked")
    public FeatureToggle(T instance, MethodStatus defaultStatus, Class<? super T>[] interfaces) {
        interfacesString = Arrays.stream(interfaces)
                .peek(Preconditions::interfacee)
                .peek(it -> Arrays.stream(it.getMethods()).forEach(m -> methods.put(m.getName(), defaultStatus)))
                .map(Class::getSimpleName).collect(Collectors.joining(" "));

        this.proxy = (T) Proxy.newProxyInstance(
                FeatureToggle.class.getClassLoader(),
                interfaces,
                new FeatureToggleInvocationHandler(instance, methods)
        );
    }

    public T getProxy() {
        return proxy;
    }

    public boolean isEnabled(String methodName) {
        return MethodStatus.ENABLED == getMethodStatus(methodName);
    }

    public boolean isDisabled(String methodName) {
        return MethodStatus.DISABLED == getMethodStatus(methodName);
    }

    public MethodStatus getMethodStatus(String methodName) {
        return methods.get(methodName);
    }

    public Map<String, MethodStatus> getMethodStatuses() {
        return Collections.unmodifiableMap(methods);
    }

    public void enable(String methodName) {
        setStatus(methodName, MethodStatus.ENABLED);
    }

    public void disable(String methodName) {
        setStatus(methodName, MethodStatus.DISABLED);
    }

    public void enableAll() {
        methods.keySet().forEach(this::enable);
    }

    public void disableAll() {
        methods.keySet().forEach(this::disable);
    }

    public void setStatus(String methodName, MethodStatus status) {
        if (!methods.containsKey(methodName)) {
            throw new IllegalArgumentException("Method " + methodName + " does not exist on interfaces " + interfacesString);
        }
        methods.put(methodName, Objects.requireNonNull(status));
    }

    /** inner class so one can't use "FeatureToggle.invoke" */
    private static class FeatureToggleInvocationHandler implements InvocationHandler {

        private final Object instance;
        private final Map<String, MethodStatus> methods;

        public FeatureToggleInvocationHandler(Object instance, Map<String, MethodStatus> methods) {
            this.instance = instance;
            this.methods = methods;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            String methodName = method.getName();
            MethodStatus status = methods.get(methodName);

            switch (status) {
                case ENABLED:
                    return method.invoke(instance, args);
                case DISABLED:
                default:
                    throw new UnsupportedOperationException("Calling of " + methodName + " is disabled");
            }
        }
    }

    public enum MethodStatus {
        ENABLED,
        DISABLED
    }
}
