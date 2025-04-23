package nl.hu.testendpoint.domain;

public class RAM {
    private int productid;
    private String brand;
    private int amount;
    private int memory;
    private int memoryspeed;
    private int timing;
    private int ddrversion;
    private String releasedate;
    private double price;

    public RAM() {}

    public RAM(int productid, String brand, int amount, int memory, int memoryspeed, int timing, int ddrversion, String releasedate, double price) {
        this.productid = productid;
        this.brand = brand;
        this.amount = amount;
        this.memory = memory;
        this.memoryspeed = memoryspeed;
        this.timing = timing;
        this.ddrversion = ddrversion;
        this.releasedate = releasedate;
        this.price = price;
    }

    public int getProductid() { return productid; }
    public String getBrand() { return brand; }
    public int getAmount() { return amount; }
    public int getMemory() { return memory; }
    public int getMemoryspeed() { return memoryspeed; }
    public int getTiming() { return timing; }
    public int getDdrversion() { return ddrversion; }
    public String getReleasedate() { return releasedate; }
    public double getPrice() { return price; }
}
