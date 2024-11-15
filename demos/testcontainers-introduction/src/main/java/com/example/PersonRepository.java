package com.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
    private final Connection connection;

    public PersonRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Person> getAll() {
        try (Statement statement = connection.createStatement()) {
            // SQL-Abfrage ausführen
            ResultSet resultSet = statement.executeQuery("SELECT * FROM person");

            List<Person> persons = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                persons.add(new Person(id, name));
            }
            return persons;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
