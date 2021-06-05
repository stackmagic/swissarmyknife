#!/usr/bin/env python

import os
import sys
from string import Template

srcTryParse = """
    @Test
    public void tryParse() {
        assertNull($className.tryParse("null"));
        assertEquals(($primitive) $className.tryParse("1"),                      ($primitive) new $object(($primitive) 1));
        assertEquals(($primitive) $className.tryParse("1",     ($primitive) 23), ($primitive) new $object(($primitive) 1));
        assertEquals(($primitive) $className.tryParse("1 3 4", ($primitive) 23), ($primitive) new $object(($primitive) 23));
        assertEquals(($primitive) $className.tryParse(null,    ($primitive) 23), ($primitive) new $object(($primitive) 23));
    }
"""

srcSigned = """
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void zeroLo() {
        $className.zero(($primitive) -1);
    }

    @Test
    public void isPositive() {
        assertFalse($className.isPositive(($primitive) 0));
        assertTrue($className.isPositive(($primitive) 1));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void positiveLo() {
        $className.positive(($primitive) 0);
    }

    @Test
    public void positive() {
        assertEquals($className.positive(($primitive) 1), 1);
    }

    @Test
    public void isNegative() {
        assertFalse($className.isNegative(($primitive) 0));
        assertTrue($className.isNegative(($primitive) -1));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negativeHi() {
        $className.negative(($primitive) 0);
    }

    @Test
    public void negative() {
        assertEquals($className.negative(($primitive) -1), -1);
    }

    @Test
    public void isZeroOrPositive() {
        assertFalse($className.isZeroOrPositive(($primitive) -1));
        assertTrue($className.isZeroOrPositive(($primitive) 0));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void zeroOrPositiveLo() {
        $className.zeroOrPositive(($primitive) -1);
    }

    @Test
    public void zeroOrPositive() {
        assertEquals($className.zeroOrPositive(($primitive) 0), 0);
        assertEquals($className.zeroOrPositive(($primitive) 1), 1);
    }

    @Test
    public void iszeroOrNegative() {
        assertFalse($className.isZeroOrNegative(($primitive) 1));
        assertTrue($className.isZeroOrNegative(($primitive) 0));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void zeroOrNegativeHi() {
        $className.zeroOrNegative(($primitive) 1);
    }

    @Test
    public void zeroOrNegative() {
        assertEquals($className.zeroOrNegative(($primitive) 0), 0);
        assertEquals($className.zeroOrNegative(($primitive) -1), -1);
    }

    @Test
    public void isZeroSigned() {
        assertFalse($className.isZero(($primitive) -1));
    }
"""

src = """// THIS FILE IS GENERATED, CHANGES WILL BE OVERWRITTEN
package net.swisstech.swissarmyknife.lang;

import net.swisstech.swissarmyknife.test.PrivateConstructor;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

/**
 * @since 1.2.0
 */
public class ${className}Test {

    @Test
    public void privateConstructor() throws IOException {
        PrivateConstructor.invoke($className.class);
    }
$parseSection
    @Test
    public void isZero() {
        assertFalse($className.isZero(($primitive) 1));
        assertTrue($className.isZero(($primitive) 0));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void zeroHi() {
        $className.zero(($primitive) 1);
    }

    @Test
    public void zero() {
        assertEquals($className.zero(($primitive) 0), ($primitive) 0);
    }
$signedSection
    @Test
    public void isInRangeInclusive() {
        assertTrue($className.isInRangeInclusive(($primitive) 0, ($primitive) 0, ($primitive) 0));

        assertTrue($className.isInRangeInclusive(($primitive) 0, ($primitive) 0, ($primitive) 1));
        assertTrue($className.isInRangeInclusive(($primitive) 1, ($primitive) 0, ($primitive) 1));

        assertFalse($className.isInRangeInclusive(($primitive) 0, ($primitive) 1, ($primitive) 1));
        assertFalse($className.isInRangeInclusive(($primitive) 2, ($primitive) 0, ($primitive) 0));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void inRangeInclusiveHi() {
        $className.inRangeInclusive(($primitive) 2, ($primitive) 0, ($primitive) 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void inRangeInclusiveLo() {
        $className.inRangeInclusive(($primitive) 0, ($primitive) 1, ($primitive) 2);
    }

    @Test
    public void inRangeInclusive() {
        assertEquals($className.inRangeInclusive(($primitive) 0, ($primitive) 0, ($primitive) 0), 0);
    }

    @Test
    public void isInRangeExclusive() {
        assertFalse($className.isInRangeExclusive(($primitive) 0, ($primitive) 0, ($primitive) 0));
        assertFalse($className.isInRangeExclusive(($primitive) 1, ($primitive) 0, ($primitive) 1));
        assertFalse($className.isInRangeExclusive(($primitive) 0, ($primitive) 0, ($primitive) 1));

        assertTrue($className.isInRangeExclusive(($primitive) 3, ($primitive) 2, ($primitive) 4));
        assertTrue($className.isInRangeExclusive(($primitive) 2, ($primitive) 1, ($primitive) 3));
        assertTrue($className.isInRangeExclusive(($primitive) 1, ($primitive) 0, ($primitive) 2));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void inRangeExclusiveHi() {
        $className.inRangeExclusive(($primitive) 2, ($primitive) 0, ($primitive) 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void inRangeExclusiveLo() {
        $className.inRangeExclusive(($primitive) 0, ($primitive) 0, ($primitive) 2);
    }

    @Test
    public void inRangeExclusive() {
        assertEquals($className.inRangeExclusive(($primitive) 1, ($primitive) 0, ($primitive) 2), 1);
    }

    @Test
    public void isEqual() {
        assertFalse($className.isEqual(($primitive) 0, ($primitive) 1));
        assertFalse($className.isEqual(($primitive) 1, ($primitive) 0));

        assertTrue($className.isEqual(($primitive) 0, ($primitive) 0));
        assertTrue($className.isEqual(($primitive) 1, ($primitive) 1));
        assertTrue($className.isEqual(($primitive) 42, ($primitive) 42));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void equalFalse() {
        $className.equal(($primitive) 0, ($primitive) 1);
    }

    @Test
    public void equal() {
        assertEquals($className.equal(($primitive) 0, ($primitive) 0), 0);
    }

    @Test
    public void isGreater() {
        assertTrue($className.isGreater(($primitive) 1, ($primitive) 0));
        assertFalse($className.isGreater(($primitive) 1, ($primitive) 1));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void greaterLo() {
        $className.greater(($primitive) 1, ($primitive) 1);
    }

    @Test
    public void greater() {
        assertEquals($className.greater(($primitive) 1, ($primitive) 0), 1);
    }

    @Test
    public void isGreaterOrEqual() {
        assertFalse($className.isGreaterOrEqual(($primitive) 0, ($primitive) 1));
        assertTrue($className.isGreaterOrEqual(($primitive) 1, ($primitive) 1));
        assertTrue($className.isGreaterOrEqual(($primitive) 2, ($primitive) 1));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void greaterOrEqualLo() {
        $className.greaterOrEqual(($primitive) 0, ($primitive) 1);
    }

    @Test
    public void greaterOrEqual() {
        assertEquals($className.greaterOrEqual(($primitive) 1, ($primitive) 1), 1);
        assertEquals($className.greaterOrEqual(($primitive) 2, ($primitive) 1), 2);
    }

    @Test
    public void isSmaller() {
        assertFalse($className.isSmaller(($primitive) 1, ($primitive) 1));
        assertTrue($className.isSmaller(($primitive) 0, ($primitive) 1));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void smallerHi() {
        $className.smaller(($primitive) 1, ($primitive) 1);
    }

    @Test
    public void smaller() {
        assertEquals($className.smaller(($primitive) 0, ($primitive) 1), 0);
    }

    @Test
    public void isSmallerOrEqual() {
        assertFalse($className.isSmallerOrEqual(($primitive) 1, ($primitive) 0));
        assertTrue($className.isSmallerOrEqual(($primitive) 0, ($primitive) 0));
        assertTrue($className.isSmallerOrEqual(($primitive) 42, ($primitive) 99));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void smallerOrEqualHi() {
        $className.smallerOrEqual(($primitive) 1, ($primitive) 0);
    }

    @Test
    public void smallerOrEqual() {
        assertEquals($className.smallerOrEqual(($primitive) 0, ($primitive) 0), 0);
        assertEquals($className.smallerOrEqual(($primitive) 42, ($primitive) 43), 42);
    }

    @Test
    public void limit() {
        assertEquals($className.limit(($primitive) 0, ($primitive) 0, ($primitive) 0), 0);
        assertEquals($className.limit(($primitive) 5, ($primitive) 0, ($primitive) 0), 0);

        assertEquals($className.limit(($primitive) 5, ($primitive) 5, ($primitive) 10), 5);
        assertEquals($className.limit(($primitive) 0, ($primitive) 5, ($primitive) 10), 5);

        assertEquals($className.limit(($primitive) 5, ($primitive) 0, ($primitive) 5), 5);
        assertEquals($className.limit(($primitive) 10, ($primitive) 0, ($primitive) 5), 5);
    }
}
"""

# default for maven - gradle overrides this with a commandline argument
basedir = 'target/generated-sources/number-utils-test'
if len(sys.argv) > 1:
	basedir = sys.argv[1]

dir        = '%s/net/swisstech/swissarmyknife/lang' % basedir

tuples = [
    ("Bytes",      "Byte",      "byte",   "parseByte",   False),
    ("Shorts",     "Short",     "short",  "parseShort",  False),
    ("Integers",   "Integer",   "int",    "parseInt",    False),
    ("Longs",      "Long",      "long",   "parseLong",   False),
    ("Floats",     "Float",     "float",  "parseFloat",  False),
    ("Doubles",    "Double",    "double", "parseDouble", False),
    ("Characters", "Character", "char",   None,          True)
]

try:
	os.makedirs(dir)
except:
	pass

try:
	os.remove(fileName)
except:
	pass

for tuple in tuples:

    fileName = "%s/%sTest.java" % (dir, tuple[0])

    # generate the java file
    with open(fileName, 'w+') as file:

        # values
        className=tuple[0]
        object=tuple[1]
        primitive=tuple[2]
        parseMethod=tuple[3]
        unsigned=tuple[4]

        # generate code
        parseSection = "" if parseMethod is None else Template(srcTryParse).substitute(className=className, object=object, primitive=primitive, parseMethod=parseMethod, unsigned=unsigned)
        signedSection = "" if unsigned is True else Template(srcSigned).substitute(className=className, object=object, primitive=primitive, parseMethod=parseMethod, unsigned=unsigned)
        sourceString = Template(src).substitute(className=className, object=object, primitive=primitive, parseMethod=parseMethod, unsigned=unsigned, parseSection=parseSection, signedSection=signedSection)

        # write source to file
        file.write(sourceString)
