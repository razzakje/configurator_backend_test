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
                SELECT * FROM product order by productID asc;
            """;
            try (PreparedStatement statement = conn.prepareStatement(sql);
                 ResultSet set = statement.executeQuery()) {

                while (set.next()) {
                    components.add(new Component(
                            set.getInt("productID"),
                            set.getString("type"),
                            set.getString("name"),
                            set.getString("description"),
                            set.getDouble("price")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Configurator(0, "All Components", components);
    }

    public static Configurator getConfigurator(String name) {
        List<Component> components = new ArrayList<>();
        int configurationID = -1;

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = """
                SELECT p.productID, p.name, p.type, p.description, p.price, pc.configurationID, c.name AS configName
                FROM product p
                INNER JOIN productConfiguration pc ON p.productID = pc.productID
                INNER JOIN configuration c ON pc.configurationID = c.configurationID
                WHERE c.name = ?
            """;

            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, name);
                try (ResultSet set = statement.executeQuery()) {
                    while (set.next()) {
                        components.add(new Component(
                                set.getInt("productID"),
                                set.getString("type"),
                                set.getString("name"),
                                set.getString("description"),
                                set.getDouble("price")
                        ));
                        configurationID = set.getInt("configurationID");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Configurator(configurationID, name, components);
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
