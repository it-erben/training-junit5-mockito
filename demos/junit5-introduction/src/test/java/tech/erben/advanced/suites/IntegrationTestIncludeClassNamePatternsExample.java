package tech.erben.advanced.suites;

import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages({
    "tech.erben.dummy",
})
@IncludeClassNamePatterns(".*IT")
public class IntegrationTestIncludeClassNamePatternsExample {
}
