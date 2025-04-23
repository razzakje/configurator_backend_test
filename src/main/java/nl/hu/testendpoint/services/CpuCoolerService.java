package nl.hu.testendpoint.services;

import nl.hu.testendpoint.domain.CpuCooler;
import nl.hu.testendpoint.persistence.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CpuCoolerService {

    public static List<CpuCooler> getAllCpuCoolers() {
        List<CpuCooler> components = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT cpucooler.productid, cpucooler.brand, cpucooler.sockets, cpucooler.sizeMM, cpucooler.heightMM, cpucooler.soundDB, cpucooler.releaseDate, product.price, product.name FROM cpucooler INNER JOIN product ON cpucooler.productid = product.productid;";
            try (PreparedStatement statement = conn.prepareStatement(sql);
                 ResultSet set = statement.executeQuery()) {

                while (set.next()) {
                    components.add(new CpuCooler(
                            set.getInt("productID"),
                            set.getString("brand"),
                            set.getString("sockets"),
                            set.getInt("sizeMM"),
                            set.getInt("heightMM"),
                            set.getInt("soundDB"),
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
