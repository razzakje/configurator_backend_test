package nl.hu.testendpoint.domain;

import nl.hu.testendpoint.persistence.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CPU {
    private int productid;
    private String brand;
    private String processorserie;
    private String processormodel;
    private String socket;
    private int clockspeed;
    private int cores;
    private String integradedgraphics;
    private int tdp;
    private String releasedate;
    private double price;
    private String name;

    public CPU() {}

    public CPU(int productid, String brand, String processorserie, String processormodel, String socket, int clockspeed, int cores, String integradedgraphics, int tdp, String releasedate, double price, String name) {
        this.productid = productid;
        this.brand = brand;
        this.processorserie = processorserie;
        this.processormodel = processormodel;
        this.socket = socket;
        this.clockspeed = clockspeed;
        this.cores = cores;
        this.integradedgraphics = integradedgraphics;
        this.tdp = tdp;
        this.releasedate = releasedate;
        this.price = price;
        this.name = name;
    }

    public int getProductid() { return productid; }
    public String getBrand() { return brand; }
    public String getProcessorserie() { return processorserie; }
    public String getProcessormodel() { return processormodel; }
    public String getSocket() { return socket; }
    public int getClockspeed() { return clockspeed; }
    public int getCores() { return cores; }
    public String getIntegradedgraphics() { return integradedgraphics; }
    public int getTdp() { return tdp; }
    public String getReleasedate() { return releasedate; }
    public double getPrice() { return price; }
    public String getName() { return name; }


}

