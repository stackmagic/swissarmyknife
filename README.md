
# swissarmyknife

just a bunch of small java utils to make my life easier

[ ![TravicCI](https://travis-ci.org/stackmagic/swissarmyknife.svg?branch=master) ](https://travis-ci.org/stackmagic/swissarmyknife)
[ ![Download](https://api.bintray.com/packages/stackmagic/maven/swissarmyknife/images/download.svg) ](https://bintray.com/stackmagic/maven/swissarmyknife/_latestVersion)

# downloading

## gradle

the [jcenter() shortcut requires at least gradle 1.7](http://www.gradle.org/docs/1.7/release-notes#jcenter-repository-support)

```groovy
repositories {
    jcenter()
}

dependencies {
    compile 'net.swisstech:swissarmyknife:+'
}
```

## maven

```xml
<repository>
    <id>jcenter</id>
    <url>https://jcenter.bintray.com/</url>
</repository>
```

```xml
<dependency>
    <groupId>net.swisstech</groupId>
    <artifactId>swissarmyknife</artifactId>
    <version>...</version>
</dependency>
```

# changelog

## 2.1.0

* added `AbstractCharSequence.compareTo`
* added `Stack.size` & `Stack.clear`
* added `Writers` since we already have `Readers`
* added `Floats` & `Doubles` since we already have `Integers`, `Longs`, `Bytes` and `Characters`
* moved `InputStreams` to `io` package
* refactor `Randoms`
** changed from a static util into extending `SecureRandom` so it's possible for the user to seed it
** added `next{Int|Double|Long|Float}Incluse` methods
* cleanup `Preconditions`
** remove String check, use `Strings` instead
** return the `URL` from `ensureUrl`
** remove all `@Deprecated`, that was a stupid idea (for example renaming `ensureNull()` to `null()`)
* changed `Abstract{Int|Long|Double}.compareTo` to use `{Integer|Long|Double}.compare`, was the only dependency to `ch.bind.philib`
* removed dependency to `ch.bind.philib`
* testing
** added `TeeOutputStreamTest`

## 2.0.0

* added `Strings.breakString` (will misbehave, doesn't handle edge cases)
* added `InputStreams.waitForOutput`
* added `BackgroundProcess.waitForStringInStd{our|err}`
* cleanup `ProcessWrapper`
** fix in/out/err redirecting
** fix `kill` method - didn't properly get the PID
* cleanup `DtoTesterUtil`
* cleanup `PrivateConstructor`
* cleanup `SimpleHttpServerClassloaderFileServer`
* removed `Iso639` code
* removed `javax.xml` from `Closeables` for android compatibility
