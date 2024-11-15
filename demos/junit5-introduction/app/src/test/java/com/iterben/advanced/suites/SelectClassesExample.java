package com.iterben.advanced.suites;

import com.iterben.advanced.lifecycle.DemoLifecycleTest;
import com.iterben.advanced.repeated.DemoRepeatedTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        DemoLifecycleTest.class,
        DemoRepeatedTest.class
})
public class SelectClassesExample {
}
