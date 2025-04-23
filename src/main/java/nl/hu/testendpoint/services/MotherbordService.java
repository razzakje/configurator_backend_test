package nl.hu.testendpoint.services;

import nl.hu.testendpoint.domain.Motherbord;
import nl.hu.testendpoint.persistence.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MotherbordService {

    public static List<Motherbord> getAllMotherbords() {
        List<Motherbord> components = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT motherbord.productid, motherbord.brand, motherbord.formFactor, motherbord.socket, motherbord.chipSet, motherbord.memorySlots, motherbord.maxMemory, motherbord.ddrVersion, motherbord.WIFI, motherbord.m2Slots, motherbord.usb2, motherbord.usb30gen1, motherbord.usb30gen2, motherbord.releaseDate, product.price, product.name FROM motherbord INNER JOIN product ON motherbord.productid = product.productid;";
            try (PreparedStatement statement = conn.prepareStatement(sql);
                 ResultSet set = statement.executeQuery()) {

                while (set.next()) {
                    components.add(new Motherbord(
                            set.getInt("productID"),
                            set.getString("brand"),
                            set.getString("formFactor"),
                            set.getString("socket"),
                            set.getString("chipSet"),
                            set.getInt("memorySlots"),
                            set.getInt("maxMemory"),
                            set.getInt("ddrVersion"),
                            set.getString("WIFI"),
                            set.getInt("m2Slots"),
                            set.getInt("usb2"),
                            set.getInt("usb30gen1"),
                            set.getInt("usb30gen2"),
                            set.getString("releaseDate"),
                            set.getDouble("price"),
                            set.getString("name")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return components;
    }
}
