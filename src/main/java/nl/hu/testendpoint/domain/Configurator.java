//package nl.hu.testendpoint.domain;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Configurator {
//    private int id;
//    private String name;
//    private List<Component> components;
//
//    Configurator(int id, String name, List<Component> components) {
//        this.id = id;
//        this.name = name;
//        this.components = components;
//    }
//
//    static public Configurator getConfigurator() {
//        List<Component> components = new ArrayList<>();
//        components.add(new Component("cpu", "intel core i9", 200.40));
//        components.add(new Component("cpu cooler", "shark cooler", 60.40));
//        components.add(new Component("gpu", "nvidia 5070", 500.99) {});
//        components.add(new Component("motherboard", "b550", 15) {});
//        components.add(new Component("memory", "Intel i9", 10) {});
//        components.add(new Component("storage", "Intel i9", 10) {});
//        components.add(new Component("case", "Intel i9", 100) {});
//        components.add(new Component("psu", "Intel i9", 10) {});
//        components.add(new Component("os", "Intel i9", 10) {});
//        return new Configurator(1,"dewan", components);
//    }
//
//    public int getId() {
//        return id;
//    }
//    public String getName() {
//        return name;
//    }
//    public List<Component> getAllComponents() {
//        return components;
//    }
//}

package nl.hu.testendpoint.domain;

import jakarta.annotation.Resource;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Configurator {
    @Resource(name = "jdbc/PostgresDS")
    private static DataSource dataSource;

    public static List<Component> getAllComponents() {
        List<Component> components = new ArrayList<>();
        String sql = "SELECT name, description, price FROM components"; // Assuming your table has these columns.

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String componentName = resultSet.getString("name");
                String componentDescription = resultSet.getString("description");
                double componentPrice = resultSet.getDouble("price");

                // Create and add Component objects to the list
                components.add(new Component(id, componentName, componentDescription, componentPrice));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return components;
    }
}
