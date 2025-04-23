package nl.hu.testendpoint.domain;

public class CpuCooler {
    private int productid;
    private String brand;
    private String sockets;
    private int sizemm;
    private int heightmm;
    private int sounddb;
    private String releasedate;
    private double price;
    private String name;

    public CpuCooler() {}

    public CpuCooler(int productid, String brand, String sockets, int sizemm, int heightmm, int sounddb, String releasedate, double price, String name) {
        this.productid = productid;
        this.brand = brand;
        this.sockets = sockets;
        this.sizemm = sizemm;
        this.heightmm = heightmm;
        this.sounddb = sounddb;
        this.releasedate = releasedate;
        this.price = price;
        this.name = name;
    }

    public int getProductid() { return productid; }
    public String getBrand() { return brand; }
    public String getSockets() { return sockets; }
    public int getSizemm() { return sizemm; }
    public int getHeightmm() { return heightmm; }
    public int getSounddb() { return sounddb; }
    public String getReleasedate() { return releasedate; }
    public double getPrice() { return price; }
    public String getName() { return name; }
}
