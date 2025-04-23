package nl.hu.testendpoint.domain;

public class Motherbord {
    private int productid;
    private String brand;
    private String formfactor;
    private String socket;
    private String chipset;
    private int memoryslots;
    private int maxmemory;
    private int ddrversion;
    private String wifi;
    private int m2slots;
    private int usb2;
    private int usb30gen1;
    private int usb30gen2;
    private String releasedate;
    private double price;
    private String name;

    public Motherbord() {}

    public Motherbord(int productid, String brand, String formfactor, String socket, String chipset, int memoryslots, int maxmemory, int ddrversion, String wifi, int m2slots, int usb2, int usb30gen1, int usb30gen2, String releasedate, double price, String name) {
        this.productid = productid;
        this.brand = brand;
        this.formfactor = formfactor;
        this.socket = socket;
        this.chipset = chipset;
        this.memoryslots = memoryslots;
        this.maxmemory = maxmemory;
        this.ddrversion = ddrversion;
        this.wifi = wifi;
        this.m2slots = m2slots;
        this.usb2 = usb2;
        this.usb30gen1 = usb30gen1;
        this.usb30gen2 = usb30gen2;
        this.releasedate = releasedate;
        this.price = price;
        this.name = name;
    }

    public int getProductid() { return productid; }
    public String getBrand() { return brand; }
    public String getFormfactor() { return formfactor; }
    public String getSocket() { return socket; }
    public String getChipset() { return chipset; }
    public int getMemoryslots() { return memoryslots; }
    public int getMaxmemory() { return maxmemory; }
    public int getDdrversion() { return ddrversion; }
    public String getWifi() { return wifi; }
    public int getM2slots() { return m2slots; }
    public int getUsb2() { return usb2; }
    public int getUsb30gen1() { return usb30gen1; }
    public int getUsb30gen2() { return usb30gen2; }
    public String getReleasedate() { return releasedate; }
    public double getPrice() { return price; }
    public String getName() { return name; }
}
