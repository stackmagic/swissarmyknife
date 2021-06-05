#!/usr/bin/env python

import os
import sys
from string import Template

srcTryParse = """
    public static $object tryParse(String text, $object def) {
        if (text == null) {
            return def;
        }
        try {
            return $object.$parseMethod(text);
        } catch (NumberFormatException e) {
            return def;
        }
    }

    public static $object tryParse(String text) {
        return tryParse(text, null);
    }
"""

srcSigned = """
    public static boolean isPositive($primitive v) {
        return v > 0;
    }

    public static $primitive positive($primitive v) {
        if (isPositive(v)) {
            return v;
        }
        throw new IllegalArgumentException("Expected $primitive to be positive but got " + v);
    }

    public static boolean isNegative($primitive v) {
        return v < 0;
    }

    public static $primitive negative($primitive v) {
        if (isNegative(v)) {
            return v;
        }
        throw new IllegalArgumentException("Expected $primitive to be negative but got " + v);
    }

    public static boolean isZeroOrPositive($primitive v) {
        return v >= 0;
    }

    public static $primitive zeroOrPositive($primitive v) {
        if (isZeroOrPositive(v)) {
            return v;
        }
        throw new IllegalArgumentException("Expected $primitive to be zero or positive but got " + v);
    }

    public static boolean isZeroOrNegative($primitive v) {
        return v <= 0;
    }

    public static $primitive zeroOrNegative($primitive v) {
        if (isZeroOrNegative(v)) {
            return v;
        }
        throw new IllegalArgumentException("Expected $primitive to be zero or negative but got " + v);
    }
"""

src = """// THIS FILE IS GENERATED, CHANGES WILL BE OVERWRITTEN
package net.swisstech.swissarmyknife.lang;

/**
 * some $primitive number utils
 *
 * @since 1.2.0
 */
public final class $className {

    /** private constructor for utility class */
    private $className() {
    }
$parseSection
    public static boolean isZero($primitive v) {
        return v == 0;
    }

    public static $primitive zero($primitive v) {
        if (isZero(v)) {
            return v;
        }
        throw new IllegalArgumentException("Expected $primitive to equal 0 but got " + v);
    }
$signedSection
    public static boolean isInRangeInclusive($primitive v, $primitive lo, $primitive hi) {
        return v >= lo && v <= hi;
    }

    public static $primitive inRangeInclusive($primitive v, $primitive lo, $primitive hi) {
        if (isInRangeInclusive(v, lo, hi)) {
            return v;
        }
        throw new IllegalArgumentException("Expected " + v + " to be in range " + lo + " .. " + hi + " inclusive");
    }

    public static boolean isInRangeExclusive($primitive v, $primitive lo, $primitive hi) {
        return v > lo && v < hi;
    }

    public static $primitive inRangeExclusive($primitive v, $primitive lo, $primitive hi) {
        if (isInRangeExclusive(v, lo, hi)) {
            return v;
        }
        throw new IllegalArgumentException("Expected " + v + " to be in range " + lo + " .. " + hi + " exclusive");
    }

    public static boolean isEqual($primitive exp, $primitive act) {
        return exp == act;
    }

    public static $primitive equal($primitive exp, $primitive act) {
        if (isEqual(exp, act)) {
            return act;
        }
        throw new IllegalArgumentException("Expected " + act + " to equal to " + exp);
    }

    public static boolean isGreater($primitive v, $primitive lo) {
        return v > lo;
    }

    public static $primitive greater($primitive v, $primitive lo) {
        if (isGreater(v, lo)) {
            return v;
        }
        throw new IllegalArgumentException("Expected " + v + " to be greater than " + lo);
    }

    public static boolean isGreaterOrEqual($primitive v, $primitive lo) {
        return v >= lo;
    }

    public static $primitive greaterOrEqual($primitive v, $primitive lo) {
        if (isGreaterOrEqual(v, lo)) {
            return v;
        }
        throw new IllegalArgumentException("Expected " + v + " to be greater or equal to " + lo);
    }

    public static boolean isSmaller($primitive v, $primitive hi) {
        return v < hi;
    }

    public static $primitive smaller($primitive v, $primitive hi) {
        if (isSmaller(v, hi)) {
            return v;
        }
        throw new IllegalArgumentException("Expected " + v + " to be smaller than " + hi);
    }

    public static boolean isSmallerOrEqual($primitive v, $primitive hi) {
        return v <= hi;
    }

    public static $primitive smallerOrEqual($primitive v, $primitive hi) {
        if (isSmallerOrEqual(v, hi)) {
            return v;
        }
        throw new IllegalArgumentException("Expected " + v + " to be smaller or equal to " + hi);
    }

    public static $primitive limit($primitive v, $primitive lo, $primitive hi) {
        return ($primitive) Math.min(Math.max(v, lo), hi);
    }
}
"""

# default for maven - gradle overrides this with a commandline argument
basedir = 'target/generated-sources/number-utils'
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

    fileName = "%s/%s.java" % (dir, tuple[0])

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
