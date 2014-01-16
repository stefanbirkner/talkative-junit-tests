package com.github.stefanbirkner.junit.talkative;

import org.junit.*;
import org.junit.internal.AssumptionViolatedException;
import org.junit.internal.runners.model.EachTestNotifier;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.ParentRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import java.util.Arrays;
import java.util.List;

public class TalkativeTests extends ParentRunner<Test> {
    /**
     * Creates a BlockJUnit4ClassRunner to run {@code klass}
     *
     * @param klass
     * @throws org.junit.runners.model.InitializationError if the test class is malformed.
     */
    public TalkativeTests(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected List<Test> getChildren() {
        try {
            return Arrays.asList((Test[]) getTestClass().getJavaClass().getField("tests").get(null));
        } catch (IllegalAccessException e) {
           throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected Description describeChild(Test child) {
        return Description.createTestDescription(getTestClass().getJavaClass(), child.name);
    }

    @Override
    protected void runChild(Test child, RunNotifier notifier) {
        Description description = describeChild(child);
        EachTestNotifier eachNotifier = new EachTestNotifier(notifier, description);
        eachNotifier.fireTestStarted();
        try {
            child.statement.execute();
        } catch (AssumptionViolatedException e) {
            eachNotifier.addFailedAssumption(e);
        } catch (Throwable e) {
            eachNotifier.addFailure(e);
        } finally {
            eachNotifier.fireTestFinished();
        }
    }
}
