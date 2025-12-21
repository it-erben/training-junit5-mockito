package tech.erben.advanced.suites;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages({
    "tech.erben.fibonacci",
    "tech.erben.junitbasics"
})
public class SelectPackagesExample {
}
