package nl.hu.testendpoint.services;

import nl.hu.testendpoint.domain.Storage;
import nl.hu.testendpoint.persistence.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StorageService {

    public static List<Storage> getAllStorages() {
        List<Storage> components = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT storage.productid, storage.brand, storage.storageCapacity, storage.storageConnection, storage.readSpeed, storage.diskSpeed, storage.storageType, storage.releaseDate, product.price FROM storage INNER JOIN product ON storage.productid = product.productid;";
            try (PreparedStatement statement = conn.prepareStatement(sql);
                 ResultSet set = statement.executeQuery()) {

                while (set.next()) {
                    components.add(new Storage(
                            set.getInt("productID"),
                            set.getString("brand"),
                            set.getInt("storageCapacity"),
                            set.getString("storageConnection"),
                            set.getInt("readSpeed"),
                            set.getInt("diskSpeed"),
                            set.getString("storageType"),
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
