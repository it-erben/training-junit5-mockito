package tech.erben.advanced.suites;

import tech.erben.advanced.lifecycle.DemoLifecycleTest;
import tech.erben.advanced.repeated.DemoRepeatedTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        DemoLifecycleTest.class,
        DemoRepeatedTest.class
})
public class SelectClassesExample {
}
