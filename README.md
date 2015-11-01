# talkative-junit-tests

[![Build Status](https://secure.travis-ci.org/stefanbirkner/talkative-junit-tests.png)](https://travis-ci.org/stefanbirkner/talkative-junit-tests)

## Release Guide

* Select a new version according to the
  [Semantic Versioning 2.0.0 Standard](http://semver.org/).
* Set the new version in `pom.xml` and in the `Installation` section of
  this readme.
* Commit the modified `pom.xml` and `README.md`.
* Run `mvn clean deploy` with JDK 8.
* Add a tag for the release: `git tag talkative-junit-tests-X.X.X`
