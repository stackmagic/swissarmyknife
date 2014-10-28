package net.swisstech.swissarmyknife.lang;

/** can be used for your own string implementations, just extend this class */
public abstract class AbstractCharSequence implements CharSequence {

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
		return new StringBuilder(value).toString();
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
		}
		else if (!value.equals(other.value)) {
			return false;
		}
		return true;
	}
}
