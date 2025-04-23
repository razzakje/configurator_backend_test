package nl.hu.testendpoint.domain;

public class OS {
    private int productid;
    private String operatingsystem;
    private double price;
    private String name;

    public OS() {}

    public OS(int productid, String operatingsystem, double price, String name) {
        this.productid = productid;
        this.operatingsystem = operatingsystem;
        this.price = price;
        this.name = name;
    }

    public int getProductid() { return productid; }
    public String getOperatingsystem() { return operatingsystem; }
    public double getPrice() { return price; }
    public String getName() { return name; }
}
