package nl.hu.testendpoint.domain;

public class Component {

    private String type;
    private String name;
    private double price;

    public Component(String type, String name, double price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    // Getters en Setters
    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}

