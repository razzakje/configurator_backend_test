package nl.hu.testendpoint.domain;

public class Component {
    private int id;
    private String type;
    private String name;
    private double price;

    public Component(int id, String type, String name, double price) {
        this.id = id;
        this.type = type;
        this.name = name;
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

    public double getPrice() {
        return price;
    }

}

