package ua.lviv.iot.shop.model;

public class FishingRods extends FishingShop {
	private double maximumWeight;
	private double length;

	public FishingRods() {

	}

	public FishingRods(double price, String name, double masa, String material, Producer producer, int guarantee,
			String color, Season season, FishingSetType fishingsetype, double maximumWeight, double length) {
		super(price, name, masa, material, producer, guarantee, color, season, fishingsetype);
		this.length = length;
		this.maximumWeight = maximumWeight;
	}

	public double getMaximumWeight() {
		return maximumWeight;
	}

	public void setMaximumWeight(double maximumWeight) {
		this.maximumWeight = maximumWeight;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}
	
	public String getHeaders() {
        return super.getHeaders() + "," + "maximumWeight" + "," + "length";
    }
    
    public String toCVS() {
        return super.toCVS() + "," + maximumWeight + "," + length;
    }

}
