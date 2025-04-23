package nl.hu.testendpoint.services;

import nl.hu.testendpoint.domain.PSU;
import nl.hu.testendpoint.persistence.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PSUService {

    public static List<PSU> getAllPSUs() {
        List<PSU> components = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT psu.productid, psu.brand, psu.power, psu.certificate80Plus, psu.releaseDate, product.price, product.name FROM psu INNER JOIN product ON psu.productid = product.productid;";
            try (PreparedStatement statement = conn.prepareStatement(sql);
                 ResultSet set = statement.executeQuery()) {

                while (set.next()) {
                    components.add(new PSU(
                            set.getInt("productID"),
                            set.getString("brand"),
                            set.getInt("power"),
                            set.getString("certificate80Plus"),
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
