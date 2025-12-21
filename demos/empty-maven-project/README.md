# JUnit 5 zu einem Maven-Projekt hinzufügen

- Dependency in [POM](pom.xml) anpassen

  ```xml
  <dependencies>
      <!-- JUnit 5 dependency -->
      <dependency>
          <groupId>org.junit.jupiter</groupId>
          <artifactId>junit-jupiter-engine</artifactId>
          <version>5.8.1</version>
          <scope>test</scope>
      </dependency>
  </dependencies>
  ```

- Optional: Surefire konfigurieren

  ```xml
  <build>
      <plugins>
          <plugin>
              <groupId>org.apache.maven.plugins</groupId>
              <artifactId>maven-surefire-plugin</artifactId>
              <version>2.22.2</version>
              <configuration>
                  <includes>
                      <include>**/*Test.java</include>
                  </includes>
              </configuration>
          </plugin>
      </plugins>
  </build>
  ```
