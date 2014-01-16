package com.github.stefanbirkner.junit.talkative;

import org.junit.runner.RunWith;

import static com.github.stefanbirkner.junit.talkative.Test.$;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(TalkativeTests.class)
public class ExampleTest {
    public static Test[] tests = {
            $("a is set to the correct value", () -> {
                int a = 1;
                assertEquals(1, a);
            }),
            $("true is not false (version 1)", () -> {
                assertNotEquals(true, false);
            }),
            $("true is not false (version 2)", () -> assertNotEquals(true, false))
    };
}
