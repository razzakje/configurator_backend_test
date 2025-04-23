package nl.hu.testendpoint.domain;

public class GPU {
    private int productid;
    private String brand;
    private String gpuserie;
    private String gpumodel;
    private int vram;
    private int businterface;
    private int gpuclock;
    private int memoryclock;
    private String releasedate;
    private double price;
    private String name;

    public GPU() {}

    public GPU(int productid, String brand, String gpuserie, String gpumodel, int vram, int businterface, int gpuclock, int memoryclock, String releasedate, double price, String name) {
        this.productid = productid;
        this.brand = brand;
        this.gpuserie = gpuserie;
        this.gpumodel = gpumodel;
        this.vram = vram;
        this.businterface = businterface;
        this.gpuclock = gpuclock;
        this.memoryclock = memoryclock;
        this.releasedate = releasedate;
        this.price = price;
        this.name = name;
    }

    public int getProductid() { return productid; }
    public String getBrand() { return brand; }
    public String getGpuserie() { return gpuserie; }
    public String getGpumodel() { return gpumodel; }
    public int getVram() { return vram; }
    public int getBusinterface() { return businterface; }
    public int getGpuclock() { return gpuclock; }
    public int getMemoryclock() { return memoryclock; }
    public String getReleasedate() { return releasedate; }
    public double getPrice() { return price; }
    public String getName() { return name; }
}
