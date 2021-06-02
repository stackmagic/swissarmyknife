package net.swisstech.swissarmyknife.lang;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Wraps a StringBuilder, exposes all its methods and a few more. Implements the same Interfaces.
 * Extra methods are for:
 * - indenting
 * <p>
 * Unfortunately can't extend StringBuilder since it is final.
 *
 * @since 2.0.0
 */
public class StringBuilderWrapper implements Appendable, CharSequence, Serializable {

    private final StringBuilder stringBuilder;
    private final AtomicInteger indent = new AtomicInteger(0);
    private String lineSeparator = System.lineSeparator();
    private String indentString = "\t";

    public StringBuilderWrapper() {
        this(new StringBuilder());
    }

    public StringBuilderWrapper(int capacity) {
        this(new StringBuilder(capacity));
    }

    public StringBuilderWrapper(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    /** Get the value for indentation */
    public int getIndent() {
        return indent.get();
    }

    /** Set the value for indentation */
    public StringBuilderWrapper setIndent(int indentation) {
        indent.set(indentation);
        return this;
    }

    /** Get the String to indent with (default is '\t') */
    public String getIndentString() {
        return indentString;
    }

    /** Set the String to indent with; */
    public StringBuilderWrapper setIndentString(String indentString) {
        this.indentString = indentString;
        return this;
    }

    /** Increase indentation */
    public StringBuilderWrapper indentMore() {
        indent.incrementAndGet();
        return this;
    }

    /** Decrease indentation */
    public StringBuilderWrapper indentLess() {
        indent.decrementAndGet();
        return this;
    }

    /** Append the indentation to the String */
    public StringBuilderWrapper indent() {
        int indent = getIndent();
        String indentString = getIndentString();
        for (int i = 0; i < indent; i++) {
            append(indentString);
        }
        return this;
    }

    /** Get the line separator (default value is System.lineSeparator()) */
    public String getLineSeparator() {
        return lineSeparator;
    }

    /** Set the line separator */
    public void setLineSeparator(String lineSeparator) {
        this.lineSeparator = lineSeparator;
    }

    /** append a line separator */
    public StringBuilderWrapper appendLineSeparator() {
        return append(lineSeparator);
    }


    public StringBuilderWrapper append(Object obj) {
        stringBuilder.append(obj);
        return this;
    }

    public StringBuilderWrapper append(long lng) {
        stringBuilder.append(lng);
        return this;
    }

    public int codePointAt(int index) {
        return stringBuilder.codePointAt(index);
    }

    public StringBuilderWrapper append(float f) {
        stringBuilder.append(f);
        return this;
    }

    public StringBuilderWrapper append(int i) {
        stringBuilder.append(i);
        return this;
    }

    public StringBuilderWrapper delete(int start, int end) {
        stringBuilder.delete(start, end);
        return this;
    }

    public StringBuilderWrapper insert(int offset, Object obj) {
        stringBuilder.insert(offset, obj);
        return this;
    }

    public void ensureCapacity(int minimumCapacity) {
        stringBuilder.ensureCapacity(minimumCapacity);
    }

    public StringBuilderWrapper deleteCharAt(int index) {
        stringBuilder.deleteCharAt(index);
        return this;
    }

    public StringBuilderWrapper insert(int offset, String str) {
        stringBuilder.insert(offset, str);
        return this;
    }

    public int codePointCount(int beginIndex, int endIndex) {
        return stringBuilder.codePointCount(beginIndex, endIndex);
    }

    public int capacity() {
        return stringBuilder.capacity();
    }

    public StringBuilderWrapper replace(int start, int end, String str) {
        stringBuilder.replace(start, end, str);
        return this;
    }

    public StringBuilderWrapper append(double d) {
        stringBuilder.append(d);
        return this;
    }

    public StringBuilderWrapper reverse() {
        stringBuilder.reverse();
        return this;
    }

    public int indexOf(String str) {
        return stringBuilder.indexOf(str);
    }

    public StringBuilderWrapper appendCodePoint(int codePoint) {
        stringBuilder.appendCodePoint(codePoint);
        return this;
    }

    public String substring(int start, int end) {
        return stringBuilder.substring(start, end);
    }

    public StringBuilderWrapper insert(int offset, char c) {
        stringBuilder.insert(offset, c);
        return this;
    }

    public void setLength(int newLength) {
        stringBuilder.setLength(newLength);
    }

    public StringBuilderWrapper append(String str) {
        stringBuilder.append(str);
        return this;
    }

    public StringBuilderWrapper insert(int offset, int i) {
        stringBuilder.insert(offset, i);
        return this;
    }

    public StringBuilderWrapper append(StringBuffer sb) {
        stringBuilder.append(sb);
        return this;
    }

    public StringBuilderWrapper insert(int offset, long l) {
        stringBuilder.insert(offset, l);
        return this;
    }

    public String substring(int start) {
        return stringBuilder.substring(start);
    }

    public StringBuilderWrapper append(char[] str) {
        stringBuilder.append(str);
        return this;
    }

    public StringBuilderWrapper insert(int dstOffset, CharSequence s, int start, int end) {
        stringBuilder.insert(dstOffset, s, start, end);
        return this;
    }

    public StringBuilderWrapper insert(int offset, float f) {
        stringBuilder.insert(offset, f);
        return this;
    }

    public int codePointBefore(int index) {
        return stringBuilder.codePointBefore(index);
    }

    public StringBuilderWrapper insert(int index, char[] str, int offset, int len) {
        stringBuilder.insert(index, str, offset, len);
        return this;
    }

    public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
        stringBuilder.getChars(srcBegin, srcEnd, dst, dstBegin);
    }

    public StringBuilderWrapper insert(int offset, boolean b) {
        stringBuilder.insert(offset, b);
        return this;
    }

    public StringBuilderWrapper insert(int offset, double d) {
        stringBuilder.insert(offset, d);
        return this;
    }

    public int indexOf(String str, int fromIndex) {
        return stringBuilder.indexOf(str, fromIndex);
    }

    public void trimToSize() {
        stringBuilder.trimToSize();
    }

    public StringBuilderWrapper append(boolean b) {
        stringBuilder.append(b);
        return this;
    }

    public StringBuilderWrapper insert(int dstOffset, CharSequence s) {
        stringBuilder.insert(dstOffset, s);
        return this;
    }

    public int lastIndexOf(String str, int fromIndex) {
        return stringBuilder.lastIndexOf(str, fromIndex);
    }

    public StringBuilderWrapper insert(int offset, char[] str) {
        stringBuilder.insert(offset, str);
        return this;
    }

    public int lastIndexOf(String str) {
        return stringBuilder.lastIndexOf(str);
    }

    public int offsetByCodePoints(int index, int codePointOffset) {
        return stringBuilder.offsetByCodePoints(index, codePointOffset);
    }

    public StringBuilderWrapper append(char[] str, int offset, int len) {
        stringBuilder.append(str, offset, len);
        return this;
    }

    public void setCharAt(int index, char ch) {
        stringBuilder.setCharAt(index, ch);
    }

    @Override
    public StringBuilderWrapper append(CharSequence s) {
        stringBuilder.append(s);
        return this;
    }

    @Override
    public StringBuilderWrapper append(CharSequence s, int start, int end) {
        stringBuilder.append(s, start, end);
        return this;
    }

    @Override
    public StringBuilderWrapper append(char c) {
        stringBuilder.append(c);
        return this;
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }

    @Override
    public int length() {
        return stringBuilder.length();
    }

    @Override
    public char charAt(int index) {
        return stringBuilder.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return stringBuilder.subSequence(start, end);
    }

    @Override
    public IntStream chars() {
        return stringBuilder.chars();
    }

    @Override
    public IntStream codePoints() {
        return stringBuilder.codePoints();
    }
}
