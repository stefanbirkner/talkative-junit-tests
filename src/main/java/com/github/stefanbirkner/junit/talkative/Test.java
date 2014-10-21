package com.github.stefanbirkner.junit.talkative;

/**
 * A single test. The test has a name and a
 * {@link com.github.stefanbirkner.junit.talkative.Statement}, that stores the test's code.
 */
public class Test {
    public final String name;
    public final Statement statement;

    public static Test $(String name, Statement statement) {
        return new Test(name, statement);
    }

    public Test(String name, Statement statement) {
        this.name = name;
        this.statement = statement;
    }
}
