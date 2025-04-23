package nl.hu.testendpoint.domain;

public class PcCase {
    private int productid;
    private String brand;
    private String motherboardformat;
    private int fansbottom;
    private int fansside;
    private int maximumcpucoolerheight;
    private int maximumgpulength;
    private int maximumpsulength;
    private int height;
    private int width;
    private int depth;
    private String releasedate;
    private double price;

    public PcCase() {}

    public PcCase(int productid, String brand, String motherboardformat, int fansbottom, int fansside, int maximumcpucoolerheight, int maximumgpulength, int maximumpsulength, int height, int width, int depth, String releasedate, double price) {
        this.productid = productid;
        this.brand = brand;
        this.motherboardformat = motherboardformat;
        this.fansbottom = fansbottom;
        this.fansside = fansside;
        this.maximumcpucoolerheight = maximumcpucoolerheight;
        this.maximumgpulength = maximumgpulength;
        this.maximumpsulength = maximumpsulength;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.releasedate = releasedate;
        this.price = price;
    }

    public int getProductid() { return productid; }
    public String getBrand() { return brand; }
    public String getMotherboardformat() { return motherboardformat; }
    public int getFansbottom() { return fansbottom; }
    public int getFansside() { return fansside; }
    public int getMaximumcpucoolerheight() { return maximumcpucoolerheight; }
    public int getMaximumgpulength() { return maximumgpulength; }
    public int getMaximumpsulength() { return maximumpsulength; }
    public int getHeight() { return height; }
    public int getWidth() { return width; }
    public int getDepth() { return depth; }
    public String getReleasedate() { return releasedate; }
    public double getPrice() { return price; }
}
