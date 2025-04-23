package nl.hu.testendpoint.domain;

public class OS {
    private int productid;
    private String operatingsystem;
    private double price;

    public OS() {}

    public OS(int productid, String operatingsystem, double price) {
        this.productid = productid;
        this.operatingsystem = operatingsystem;
        this.price = price;
    }

    public int getProductid() { return productid; }
    public String getOperatingsystem() { return operatingsystem; }
    public double getPrice() { return price; }
}
