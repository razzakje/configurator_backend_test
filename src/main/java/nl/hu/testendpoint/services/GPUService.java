package nl.hu.testendpoint.services;

import nl.hu.testendpoint.domain.GPU;
import nl.hu.testendpoint.persistence.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GPUService {

    public static List<GPU> getAllGPUs() {
        List<GPU> components = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT gpu.productid, gpu.brand, gpu.gpuSerie, gpu.gpuModel, gpu.vram, gpu.busInterface, gpu.gpuClock, gpu.memoryClock, gpu.releaseDate, product.price FROM gpu INNER JOIN product ON gpu.productid = product.productid;";
            try (PreparedStatement statement = conn.prepareStatement(sql);
                 ResultSet set = statement.executeQuery()) {

                while (set.next()) {
                    components.add(new GPU(
                            set.getInt("productID"),
                            set.getString("brand"),
                            set.getString("gpuSerie"),
                            set.getString("gpuModel"),
                            set.getInt("vram"),
                            set.getInt("busInterface"),
                            set.getInt("gpuClock"),
                            set.getInt("memoryClock"),
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
