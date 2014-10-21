package com.github.stefanbirkner.junit.talkative;

/**
 * A test's code. This interface can be used as a functional interface.
 */
public interface Statement {
    /**
     * Run the statement, throwing a {@code java.lang.Throwable} if anything goes wrong.
     *
     * @throws Throwable if something goes wrong.
     */
    void execute() throws Throwable;
}
