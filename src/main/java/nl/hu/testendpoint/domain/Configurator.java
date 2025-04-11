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
    public static Configurator getComponents() {
        List<Component> components = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = """
                SELECT * FROM product;
            """;
            try (PreparedStatement statement = conn.prepareStatement(sql);
                 ResultSet set = statement.executeQuery()) {

                while (set.next()) {
                    components.add(new Component(
                            set.getInt("productID"),
                            set.getString("type"),
                            set.getString("naam"),
                            set.getDouble("prijs")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Configurator(0, "All Components", components);
    }

    public static Configurator getConfigurator(int configuratieID) {
        List<Component> components = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = """
                SELECT p.productID, p.naam, p.type, p.prijs
                FROM product p
                INNER JOIN productConfiguratie pc ON p.productID = pc.productID
                WHERE pc.configuratieID = ?
            """;

            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, configuratieID);
                try (ResultSet set = statement.executeQuery()) {
                    while (set.next()) {
                        components.add(new Component(
                                set.getInt("productID"),
                                set.getString("type"),
                                set.getString("naam"),
                                set.getDouble("prijs")
                        ));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Configurator(configuratieID, "Configurator " + configuratieID, components);
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
