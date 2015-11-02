# talkative-junit-tests

[![Build Status](https://secure.travis-ci.org/stefanbirkner/talkative-junit-tests.png)](https://travis-ci.org/stefanbirkner/talkative-junit-tests)

## Installation

talkative-junit-tests is currently not available from Maven Central. (If you
want me to publish it to Maven Central, please
[open an issue](https://github.com/stefanbirkner/talkative-junit-tests/issues/new).)
Therefore you have to clone this repository and build the library by yourself:

    mvn clean install -Dgpg.skip

Afterwards you can add the dependency

    <dependency>
      <groupId>com.github.stefanbirkner</groupId>
      <artifactI>talkative-junit-tests</artifactId>
      <version>0.0.1-SNAPSHOT</version>
      <scope>test</scope>
    </dependency>

## Release Guide

* Select a new version according to the
  [Semantic Versioning 2.0.0 Standard](http://semver.org/).
* Set the new version in `pom.xml` and in the `Installation` section of
  this readme.
* Commit the modified `pom.xml` and `README.md`.
* Run `mvn clean deploy` with JDK 8.
* Add a tag for the release: `git tag talkative-junit-tests-X.X.X`
