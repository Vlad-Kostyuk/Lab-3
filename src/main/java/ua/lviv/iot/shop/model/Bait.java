package ua.lviv.iot.shop.model;

public class Bait extends FishingShop {

    private double length;

    public Bait() {

    }

    public Bait(double price, String name, double masa, String material, Producer producer, int guarantee, String color,
            Season season, FishingSetType fishingsetype, double length) {
        super(price, name, masa, material, producer, guarantee, color, season, fishingsetype);
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getHeaders() {
        return super.getHeaders() + "," + "length";
    }
    
    public String toCVS() {
        return String.valueOf(super.toCVS() + "," + length);
    }
    

}
