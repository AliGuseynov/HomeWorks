package models;

import java.util.HashMap;

public class SaleUnit {

    private long id;
    private String name;
    private double sale;
    private HashMap<String, Double> companiesSold = new HashMap<String, Double>();

    public SaleUnit(long id, String name, double sale, HashMap<String, Double> companiesSold) {
        this.id = id;
        this.name = name;
        this.sale = sale;
        this.companiesSold = companiesSold;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    public HashMap<String, Double> getCompaniesSold() {
        return companiesSold;
    }

    public void setCompaniesSold(HashMap<String, Double> companiesSold) {
        this.companiesSold = companiesSold;
    }

    @Override
    public String toString() {
        return "SaleUnit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sale=" + sale +
                ", companiesSold=" + companiesSold +
                '}';
    }
}
