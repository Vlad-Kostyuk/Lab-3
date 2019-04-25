package ua.lviv.iot.shop.model;

public class FishingNet extends FishingShop {

	private int width;
	private int length;
	private String form;

	public FishingNet() {

	}

	public FishingNet(double price, String name, double masa, String material, Producer producer, int guarantee,
			String color, Season season, FishingSetType fishingsetype, int width, int length, String form) {
		super(price, name, masa, material, producer, guarantee, color, season, fishingsetype);
		this.width = width;
		this.length = length;
		this.form = form;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}
	
	public String getHeaders() {
        return super.getHeaders() + "," + "width" + "," + "length" + "," + "form";
    }
    
    public String toCVS() {
        return String.valueOf(super.toCVS() + "," + width + "," + length + "," + form);
    }

}
