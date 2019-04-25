package ua.lviv.iot.shop.model;

public class Clothing extends FishingShop {
	private Size size;
	private Sex sex;

	public Clothing() {

	}

	public Clothing(double price, String name, double masa, String material, Producer producer, int guarantee,
			String color, Season season, FishingSetType fishingsetype, Sex sex, Size size) {
		super(price, name, masa, material, producer, guarantee, color, season, fishingsetype);
		this.size = size;
		this.sex = sex;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}
	
	public String getHeaders() {
        return super.getHeaders() + "," + "size" + "," + "size";
    }
	
	public String toCVS() {
        return String.valueOf(super.toCVS() + "," + size + "," + sex);
    }
}
