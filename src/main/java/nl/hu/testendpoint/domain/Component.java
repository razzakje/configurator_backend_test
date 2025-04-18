package nl.hu.testendpoint.domain;

public class Component {
    private int id;
    private String type;
    private String name;
    private String description;
    private double price;

    public Component(int id, String type, String name,String description, double price) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }
    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

}

