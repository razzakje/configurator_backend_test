package nl.hu.testendpoint.domain;

public class Storage {
    private int productid;
    private String brand;
    private int storagecapacity;
    private String storageconnection;
    private int readspeed;
    private int diskspeed;
    private String storagetype;
    private String releasedate;
    private double price;

    public Storage() {}

    public Storage(int productid, String brand, int storagecapacity, String storageconnection, int readspeed, int diskspeed, String storagetype, String releasedate, double price) {
        this.productid = productid;
        this.brand = brand;
        this.storagecapacity = storagecapacity;
        this.storageconnection = storageconnection;
        this.readspeed = readspeed;
        this.diskspeed = diskspeed;
        this.storagetype = storagetype;
        this.releasedate = releasedate;
        this.price = price;
    }

    public int getProductid() { return productid; }
    public String getBrand() { return brand; }
    public int getStoragecapacity() { return storagecapacity; }
    public String getStorageconnection() { return storageconnection; }
    public int getReadspeed() { return readspeed; }
    public int getDiskspeed() { return diskspeed; }
    public String getStoragetype() { return storagetype; }
    public String getReleasedate() { return releasedate; }
    public double getPrice() { return price; }
}
