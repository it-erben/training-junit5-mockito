# JUnit 5 in ein neues Gradle-Projekt einbauen

- In die [Libs-Konfiguration](./gradle/libs.versions.toml) hinzufügen: 

```toml
[versions]
guava = "33.2.1-jre"
junit-jupiter = "5.10.3"

[libraries]
guava = { module = "com.google.guava:guava", version.ref = "guava" }
junit-jupiter = { module = "org.junit.jupiter:junit-jupiter", version.ref = "junit-jupiter" }
```

- Die [Build-Konfiguration](./app/build.gradle.kts) ergänzen:

```kotlin
dependencies {
    // Use JUnit Jupiter for testing.
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
```
