# Test Suite support in JUnit 5

Folgende Dependencies sind für diese Beispiele nötig:

```kotlin
testImplementation("org.junit.platform:junit-platform-suite:1.8.2")
testImplementation("org.junit.platform:junit-platform-suite-api:1.8.2")
testImplementation("org.junit.platform:junit-platform-suite-engine:1.8.2")
```

Man kann Suiten mit Gradle direkt ausführen

```shell
./gradlew test --tests \
  "tech.erben.suites.IntegrationTestIncludeClassNamePatternsExample"
```
