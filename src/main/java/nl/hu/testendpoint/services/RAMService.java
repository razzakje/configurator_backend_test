package nl.hu.testendpoint.services;

import nl.hu.testendpoint.domain.RAM;
import nl.hu.testendpoint.persistence.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RAMService {

    public static List<RAM> getAllRAMs() {
        List<RAM> components = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT ram.productid, ram.brand, ram.amount, ram.memory, ram.memorySpeed, ram.timing, ram.ddrVersion, ram.releaseDate, product.price FROM ram INNER JOIN product ON ram.productid = product.productid;";
            try (PreparedStatement statement = conn.prepareStatement(sql);
                 ResultSet set = statement.executeQuery()) {

                while (set.next()) {
                    components.add(new RAM(
                            set.getInt("productID"),
                            set.getString("brand"),
                            set.getInt("amount"),
                            set.getInt("memory"),
                            set.getInt("memorySpeed"),
                            set.getInt("timing"),
                            set.getInt("ddrVersion"),
                            set.getString("releaseDate"),
                            set.getDouble("price")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return components;
    }
}
