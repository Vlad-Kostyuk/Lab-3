package ua.lviv.iot.lab8;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class FishingShopDb {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private double price;
    private String name;
    private double masa;
    private String material;
    private int guarantee;
    private String color;

    public FishingShopDb() {

    }

    public FishingShopDb(double price, String name, double masa, String material, int guarantee,
            String color) {
        super();
        this.price = price;
        this.name = name;
        this.masa = masa;
        this.material = material;
        this.guarantee = guarantee;
        this.color = color;

    }

    @Override
    public String toString() {
        return "price=" + price + ", name=" + name + ", masa=" + masa + ", material=" + material + ", guarantee="
                + guarantee + ", color=" + color +  "\n";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMasa() {
        return masa;
    }

    public void setMasa(double masa) {
        this.masa = masa;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }


    public int getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(int guarantee) {
        this.guarantee = guarantee;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    //

    public String getHeaders() {
        return "price" + "," + "name" + "," + "masa" + "," + "material" + "," + "guarantee" + "," + "color";
    }

    public String toCVS() {
        return String.valueOf(price + "," + name + "," + masa + "," + material + "," + guarantee + "," + color);
    }
}
