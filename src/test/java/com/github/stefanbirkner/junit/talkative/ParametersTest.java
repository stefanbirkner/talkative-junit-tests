package com.github.stefanbirkner.junit.talkative;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.runner.RunWith;

@RunWith(TalkativeTests.class)
public class ParametersTest {
    public static List<Test> tests = asList(
        new Object[]{1, 2, 3},
        new Object[]{0, 2, 2},
        new Object[]{-1, 1, 0})
        .stream()
        .map(new Parameters(
            "calculates sum: {0} + {1} = {2}",
            (Object... parameters) -> {
                int sum = (int) parameters[0] + (int) parameters[1];
                assertEquals((int) parameters[2], sum);
            }))
        .collect(toList());
}
