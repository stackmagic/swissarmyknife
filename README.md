
# swissarmyknife

just a bunch of small java utils to make my life easier

[find it on search.maven.org](https://search.maven.org/search?q=g:net.swisstech%20a:swissarmyknife)
[ ![TravicCI](https://travis-ci.com/stackmagic/swissarmyknife.svg?branch=master) ](https://travis-ci.com/stackmagic/swissarmyknife)

# downloading

## gradle

```groovy
dependencies {
    compile 'net.swisstech:swissarmyknife:+'
}
```

## maven

```xml
<dependency>
    <groupId>net.swisstech</groupId>
    <artifactId>swissarmyknife</artifactId>
    <version>...</version>
</dependency>
```

# changelog

## 2.2.0

* various fixes, refactorings, new features
* switch to sonatype oss to pulish to maven central

## 2.1.0

* added `AbstractCharSequence.compareTo`
* added `Stack.size` & `Stack.clear`
* added `Writers` since we already have `Readers`
* added `Floats` & `Doubles` since we already have `Integers`, `Longs`, `Bytes` and `Characters`
* moved `InputStreams` to `io` package
* removed `Numbers`
** moved `tryParse*` into the individual type-specific classes
** added `tryParse` for the other classes
** there is no `Character.parseCharacter` and thus no `Characters.tryParse`
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
