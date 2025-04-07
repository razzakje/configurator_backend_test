package nl.hu.testendpoint.domain;
import nl.hu.testendpoint.persistence.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Configurator {
    private int id;
    private String name;
    private List<Component> components;

    public Configurator(int id, String name, List<Component> components) {
        this.id = id;
        this.name = name;
        this.components = components;
    }
    public static Configurator getConfigurator() {
        List<Component> components = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT productID, type, naam, prijs FROM product";
            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    components.add(new Component(
                            rs.getInt("productID"),
                            rs.getString("type"),
                            rs.getString("naam"),
                            rs.getDouble("prijs")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Configurator(1, "dewan", components);
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public List<Component> getAllComponents() {
        return components;
    }
}