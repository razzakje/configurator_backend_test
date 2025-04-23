package nl.hu.testendpoint.services;

import nl.hu.testendpoint.domain.Component;
import nl.hu.testendpoint.persistence.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    public List<Component> getComponentsByIds(List<Integer> ids) {
        List<Component> components = new ArrayList<>();

        if (ids == null || ids.isEmpty()) {
            return components;
        }

        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM product WHERE productID IN (");
        for (int i = 0; i < ids.size(); i++) {
            queryBuilder.append("?");
            if (i < ids.size() - 1) queryBuilder.append(",");
        }
        queryBuilder.append(")");

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(queryBuilder.toString())) {

            for (int i = 0; i < ids.size(); i++) {
                stmt.setInt(i + 1, ids.get(i));
            }

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Component component = new Component(
                        rs.getInt("productID"),
                        rs.getString("type"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("price")
                );
                components.add(component);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Replace with proper logging in production
        }

        return components;
    }
}
