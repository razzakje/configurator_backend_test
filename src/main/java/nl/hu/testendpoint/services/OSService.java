package nl.hu.testendpoint.services;

import nl.hu.testendpoint.domain.OS;
import nl.hu.testendpoint.persistence.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OSService {

    public static List<OS> getAllOSs() {
        List<OS> components = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT os.productid, os.operatingSystem, product.price, product.name FROM os INNER JOIN product ON os.productid = product.productid;";
            try (PreparedStatement statement = conn.prepareStatement(sql);
                 ResultSet set = statement.executeQuery()) {

                while (set.next()) {
                    components.add(new OS(
                            set.getInt("productID"),
                            set.getString("operatingSystem"),
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
