package nl.hu.testendpoint.domain;

import java.util.ArrayList;
import java.util.List;

public class Configurator {
    private int id;
    private String name;
    private List<Component> components;

    Configurator(int id, String name, List<Component> components) {
        this.id = id;
        this.name = name;
        this.components = components;
    }

    static public Configurator getConfigurator() {
        List<Component> components = new ArrayList<>();
        components.add(new Component("cpu", "intel core i9", 200.40));
        components.add(new Component("cpu cooler", "shark cooler", 60.40));
        components.add(new Component("gpu", "nvidia 5070", 500.99) {});
        components.add(new Component("motherboard", "b550", 15) {});
        components.add(new Component("memory", "Intel i9", 10) {});
        components.add(new Component("storage", "Intel i9", 10) {});
        components.add(new Component("case", "Intel i9", 100) {});
        components.add(new Component("psu", "Intel i9", 10) {});
        components.add(new Component("os", "Intel i9", 10) {});
        return new Configurator(1,"dewan", components);
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