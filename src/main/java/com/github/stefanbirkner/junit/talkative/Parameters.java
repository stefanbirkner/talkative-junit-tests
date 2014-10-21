package com.github.stefanbirkner.junit.talkative;

import java.text.MessageFormat;
import java.util.function.Function;

/**
 * A function for creating parameterized tests.
 */
public class Parameters implements Function<Object[], Test> {
    private final String namePattern;
    private final ParameterizedStatement statement;

    public Parameters(String namePattern, ParameterizedStatement statement) {
        this.namePattern = namePattern;
        this.statement = statement;
    }

    @Override
    public Test apply(Object[] parameters) {
        return new Test(buildNameForParameters(parameters), () -> statement.execute(parameters));
    }

    private String buildNameForParameters(Object[] parameters) {
        return MessageFormat.format(namePattern, parameters);
    }

    public static interface ParameterizedStatement {
        /**
         * Run the statement, throwing a {@code java.lang.Throwable} if anything goes wrong.
         *
         * @param parameters the parameters.
         * @throws Throwable if something goes wrong.
         */
        void execute(Object... parameters) throws Throwable;
    }
}
