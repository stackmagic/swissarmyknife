// Copyright (C) Layzapp AG. All Rights Reserved.
package net.swisstech.swissarmyknife.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * set that allows to enable/disable reading or writing. calling disabled methods will cause an UnsupportedOperationException. all methods are enabled by
 * default. hashCode/equals cannot be disabled
 * @since 1.1.4
 */
// TODO there really should be a code generator for something like this!!! and the tests for it too?!?!
public final class FeatureToggleSet<E> implements Set<E> {

	private Set<E> delegate;

	private boolean add = true;
	private boolean addAll = true;
	private boolean clear = true;
	private boolean contains = true;
	private boolean containsAll = true;
	private boolean isEmpty = true;
	private boolean iterator = true;
	private boolean remove = true;
	private boolean removeAll = true;
	private boolean retainAll = true;
	private boolean size = true;
	private boolean toArray = true;

	public FeatureToggleSet(Set<E> delegate) {
		this.delegate = delegate;
	}

	public FeatureToggleSet<E> enable() {
		add = true;
		addAll = true;
		clear = true;
		contains = true;
		containsAll = true;
		isEmpty = true;
		iterator = true;
		remove = true;
		removeAll = true;
		retainAll = true;
		size = true;
		toArray = true;
		return this;
	}

	public FeatureToggleSet<E> disable() {
		add = false;
		addAll = false;
		clear = false;
		contains = false;
		containsAll = false;
		isEmpty = false;
		iterator = false;
		remove = false;
		removeAll = false;
		retainAll = false;
		size = false;
		toArray = false;
		return this;
	}

	public FeatureToggleSet<E>  enableAdd() { this.add = true;  return this; }
	public FeatureToggleSet<E> disableAdd() { this.add = false; return this; }
	@Override
	public boolean add(E e) {
		if (add) { return delegate.add(e); }
		else { throw new UnsupportedOperationException("Can't touch this - Hammer Time!"); }

	}

	public FeatureToggleSet<E>  enableAddAll() { this.addAll = true;  return this; }
	public FeatureToggleSet<E> disableAddAll() { this.addAll = false; return this; }
	@Override
	public boolean addAll(Collection<? extends E> c) {
		if (addAll) { return delegate.addAll(c); }
		else { throw new UnsupportedOperationException("Can't touch this - Hammer Time!"); }
	}

	public FeatureToggleSet<E>  enableClear() { this.clear = true;  return this; }
	public FeatureToggleSet<E> disableClear() { this.clear = false; return this; }
	@Override
	public void clear() {
		if (clear) { delegate.clear(); }
		else { throw new UnsupportedOperationException("Can't touch this - Hammer Time!"); }
	}

	public FeatureToggleSet<E>  enableContains() { this.contains = true;  return this; }
	public FeatureToggleSet<E> disableContains() { this.contains = false; return this; }
	@Override
	public boolean contains(Object o) {
		if (contains) { return delegate.contains(o); }
		else { throw new UnsupportedOperationException("Can't touch this - Hammer Time!"); }
	}

	public FeatureToggleSet<E>  enableContainsAll() { this.containsAll = true;  return this; }
	public FeatureToggleSet<E> disableContainsAll() { this.containsAll = false; return this; }
	@Override
	public boolean containsAll(Collection<?> c) {
		if (containsAll) { return delegate.containsAll(c); }
		else { throw new UnsupportedOperationException("Can't touch this - Hammer Time!"); }
	}

	public FeatureToggleSet<E>  enableIsEmpty() { this.isEmpty = true;  return this; }
	public FeatureToggleSet<E> disableIsEmpty() { this.isEmpty = false; return this; }
	@Override
	public boolean isEmpty() {
		if (isEmpty) { return delegate.isEmpty(); }
		else { throw new UnsupportedOperationException("Can't touch this - Hammer Time!"); }
	}

	public FeatureToggleSet<E>  enableIterator() { this.iterator = true;  return this; }
	public FeatureToggleSet<E> disableIterator() { this.iterator = false; return this; }
	@Override
	public Iterator<E> iterator() {
		if (iterator) { return delegate.iterator(); }
		else { throw new UnsupportedOperationException("Can't touch this - Hammer Time!"); }
	}

	public FeatureToggleSet<E>  enableRemove() { this.remove = true;  return this; }
	public FeatureToggleSet<E> disableRemove() { this.remove = false; return this; }
	@Override
	public boolean remove(Object o) {
		if (remove) { return delegate.remove(o); }
		else { throw new UnsupportedOperationException("Can't touch this - Hammer Time!"); }
	}

	public FeatureToggleSet<E>  enableRemoveAll() { this.removeAll = true;  return this; }
	public FeatureToggleSet<E> disableRemoveAll() { this.removeAll = false; return this; }
	@Override
	public boolean removeAll(Collection<?> c) {
		if (removeAll) { return delegate.removeAll(c); }
		else { throw new UnsupportedOperationException("Can't touch this - Hammer Time!"); }
	}

	public FeatureToggleSet<E>  enableRetainAll() { this.retainAll = true;  return this; }
	public FeatureToggleSet<E> disableRetainAll() { this.retainAll = false; return this; }
	@Override
	public boolean retainAll(Collection<?> c) {
		if (retainAll) { return delegate.retainAll(c); }
		else { throw new UnsupportedOperationException("Can't touch this - Hammer Time!"); }
	}

	public FeatureToggleSet<E>  enableSize() { this.size = true;  return this; }
	public FeatureToggleSet<E> disableSize() { this.size = false; return this; }
	@Override
	public int size() {
		if (size) { return delegate.size(); }
		else { throw new UnsupportedOperationException("Can't touch this - Hammer Time!"); }
	}

	public FeatureToggleSet<E>  enableToArray() { this.toArray = true;  return this; }
	public FeatureToggleSet<E> disableToArray() { this.toArray = false; return this; }
	@Override
	public Object[] toArray() {
		if (toArray) { return delegate.toArray(); }
		else { throw new UnsupportedOperationException("Can't touch this - Hammer Time!"); }
	}

	@Override
	public <T> T[] toArray(T[] a) {
		if (toArray) { return delegate.toArray(a); }
		else { throw new UnsupportedOperationException("Can't touch this - Hammer Time!"); }
	}

	@Override
	public boolean equals(Object o) {
		return delegate.equals(o);
	}

	@Override
	public int hashCode() {
		return delegate.hashCode();
	}
}
