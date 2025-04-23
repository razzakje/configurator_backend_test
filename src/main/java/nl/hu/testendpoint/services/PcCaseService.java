package nl.hu.testendpoint.services;

import nl.hu.testendpoint.domain.PcCase;
import nl.hu.testendpoint.persistence.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PcCaseService {

    public static List<PcCase> getAllPcCases() {
        List<PcCase> components = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT pccase.productid, pccase.brand, pccase.motherboardFormat, pccase.fansBottom, pccase.fansSide, pccase.maximumCpuCoolerHeight, pccase.maximumGPULength, pccase.maximumPSULength, pccase.height, pccase.width, pccase.depth, pccase.releaseDate, product.price FROM pccase INNER JOIN product ON pccase.productid = product.productid;";
            try (PreparedStatement statement = conn.prepareStatement(sql);
                 ResultSet set = statement.executeQuery()) {

                while (set.next()) {
                    components.add(new PcCase(
                            set.getInt("productID"),
                            set.getString("brand"),
                            set.getString("motherboardFormat"),
                            set.getInt("fansBottom"),
                            set.getInt("fansSide"),
                            set.getInt("maximumCpuCoolerHeight"),
                            set.getInt("maximumGPULength"),
                            set.getInt("maximumPSULength"),
                            set.getInt("height"),
                            set.getInt("width"),
                            set.getInt("depth"),
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
