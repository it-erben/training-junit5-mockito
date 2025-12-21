package tech.erben;
import org.junit.jupiter.api.*;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
@Disabled
public class PostgresContainerTest {

    @Container
    private static final PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:15.2")
        .withDatabaseName("testdb")
        .withUsername("user")
        .withPassword("password");

    @BeforeAll
    public static void setUpDatabase() throws Exception {
        try (Connection connection = DriverManager.getConnection(
            postgresContainer.getJdbcUrl(),
            postgresContainer.getUsername(),
            postgresContainer.getPassword()
        )) {
            try (Statement statement = connection.createStatement()) {
                // Erstelle Tabelle
                statement.executeUpdate("CREATE TABLE person (id SERIAL PRIMARY KEY, name VARCHAR(255));");
                // Einfügen von Testdaten
                statement.executeUpdate("INSERT INTO person (name) VALUES ('Alice');");
                statement.executeUpdate("INSERT INTO person (name) VALUES ('Bob');");
            }
        }
    }

    @Test
    public void testQueryDatabase() throws Exception {
        try (Connection connection = DriverManager.getConnection(
            postgresContainer.getJdbcUrl(),
            postgresContainer.getUsername(),
            postgresContainer.getPassword()
        )) {
            List<Person> all = new PersonRepository(connection).getAll();
            assertEquals(2, all.size());
            assertEquals("Alice", all.get(0).getName());
        }
    }
}
