package net.swisstech.swissarmyknife.lang;

import static net.swisstech.swissarmyknife.lang.Strings.asString;

/**
 * can be used for your own string implementations, just extend this class
 *
 * @since 1.1.4
 */
public abstract class AbstractCharSequence implements CharSequence, Comparable<AbstractCharSequence> {

	private final CharSequence value;

	public AbstractCharSequence(CharSequence value) {
		this.value = value;
	}

	@Override
	public int length() {
		return value.length();
	}

	@Override
	public char charAt(int index) {
		return value.charAt(index);
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		return value.subSequence(start, end);
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	@Override
	public String toString() {
		return asString(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		AbstractCharSequence other = (AbstractCharSequence) obj;
		if (value == null) {
			if (other.value != null) {
				return false;
			}
		} else if (!value.equals(other.value)) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(AbstractCharSequence other) {
		int tl = this.length();
		int ol = other.length();
		if (tl != ol) {
			return tl - ol;
		}

		for (int i = 0; i < tl; i++) {
			char t = this.charAt(i);
			char o = other.charAt(i);
			if (t != o) {
				return t - o;
			}
		}

		return 0;
	}
}
