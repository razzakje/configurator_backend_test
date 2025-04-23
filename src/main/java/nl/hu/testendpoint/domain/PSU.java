package nl.hu.testendpoint.domain;

public class PSU {
    private int productid;
    private String brand;
    private int power;
    private String certificate80plus;
    private String releasedate;
    private double price;
    private String name;

    public PSU() {}

    public PSU(int productid, String brand, int power, String certificate80plus, String releasedate, double price, String name) {
        this.productid = productid;
        this.brand = brand;
        this.power = power;
        this.certificate80plus = certificate80plus;
        this.releasedate = releasedate;
        this.price = price;
        this.name = name;
    }

    public int getProductid() { return productid; }
    public String getBrand() { return brand; }
    public int getPower() { return power; }
    public String getCertificate80plus() { return certificate80plus; }
    public String getReleasedate() { return releasedate; }
    public double getPrice() { return price; }
    public String getName() { return name; }
}
