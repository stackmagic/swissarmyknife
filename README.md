
swissarmyknife
==============

just a bunch of small java utils to make my life easier

[ ![TravicCI](https://travis-ci.org/stackmagic/swissarmyknife.svg?branch=master) ](https://travis-ci.org/stackmagic/swissarmyknife)
[ ![Download](https://api.bintray.com/packages/stackmagic/maven/swissarmyknife/images/download.svg) ](https://bintray.com/stackmagic/maven/swissarmyknife/_latestVersion)

downloading
===========

gradle
------

the [jcenter() shortcut requires at least gradle 1.7](http://www.gradle.org/docs/1.7/release-notes#jcenter-repository-support)

```groovy
repositories {
    jcenter()
}

dependencies {
    compile 'net.swisstech:swissarmyknife:+'
}
```

maven
-----

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

