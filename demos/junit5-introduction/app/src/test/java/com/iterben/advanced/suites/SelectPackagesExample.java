package com.iterben.advanced.suites;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages({
    "com.iterben.fibonacci",
    "com.iterben.junitbasics"
})
public class SelectPackagesExample {
}
