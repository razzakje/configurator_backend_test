package nl.hu.testendpoint.services;

import nl.hu.testendpoint.domain.CPU;
import nl.hu.testendpoint.persistence.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CPUService {

    public static List<CPU> getAllCPU() {
        List<CPU> components = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT cpu.productid, cpu.brand, cpu.processorserie, cpu.processormodel, cpu.socket, cpu.clockspeed, cpu.cores, cpu.integradedgraphics, cpu.tdp, cpu.releasedate, product.price " +
                    "FROM cpu INNER JOIN product ON cpu.productid = product.productid;";
            try (PreparedStatement statement = conn.prepareStatement(sql);
                 ResultSet set = statement.executeQuery()) {

                while (set.next()) {
                    components.add(new CPU(
                            set.getInt("productID"),
                            set.getString("brand"),
                            set.getString("processorserie"),
                            set.getString("processormodel"),
                            set.getString("socket"),
                            set.getInt("clockspeed"),
                            set.getInt("cores"),
                            set.getString("integradedgraphics"),
                            set.getInt("tdp"),
                            set.getString("releasedate"),
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
