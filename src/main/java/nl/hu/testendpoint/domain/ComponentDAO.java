package nl.hu.testendpoint.persistence;

import nl.hu.testendpoint.domain.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComponentDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/Configurator";
    private static final String USER = "Postgres";
    private static final String PASSWORD = "Welkom123";

    public List<Component> findAll() {
        List<Component> components = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT type, naam, prijs FROM product"; // ← changed from producten to product
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String type = rs.getString("type");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                components.add(new Component(type, name, price));
            }
            System.out.println("Loaded " + components.size() + " components from DB.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return components;
    }
}

