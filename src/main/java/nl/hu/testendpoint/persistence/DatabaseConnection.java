package nl.hu.testendpoint.persistence;

import java.sql.*;

public class DatabaseConnection {
    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("org.postgresql.Driver");
                String url = "jdbc:postgresql://localhost:5432/configurator";
                String user = "postgres";
                String password = "Welkom123";
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                throw new SQLException("PostgreSQL JDBC Driver not found", e);
            }
        }
        return connection;
    }
}