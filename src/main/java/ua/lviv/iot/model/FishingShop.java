package ua.lviv.iot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FishingShop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private double price;
    private String name;
    private double masa;
    private String material;
    
    @Column(name = "producer")
    @Enumerated(EnumType.STRING)
    private Producer producer;
    
    private int guarantee;
    private String color;
    
    @Column(name = "season")
    @Enumerated(EnumType.STRING)
    private Season season;
    
    @Column(name = "fishingsetype")
    @Enumerated(EnumType.STRING)
    private FishingSetType fishingsetype;
    
    private FishingNet fishingnet;
    private FishingRods fishirods;
    private Bait bait;
    private Clothing clothing;
    private Sex sex;
    private Size size;

    public FishingShop() {

    }

    public FishingShop(double price, String name, double masa, String material, Producer producer, int guarantee,
            String color, Season season, FishingSetType fishingsetype) {

        this.price = price;
        this.name = name;
        this.masa = masa;
        this.material = material;
        this.producer = producer;
        this.guarantee = guarantee;
        this.color = color;
        this.season = season;
        this.fishingsetype = fishingsetype;
    }

    @Override
    public String toString() {
        return "price=" + price + ", name=" + name + ", masa=" + masa + ", material=" + material + ", producer="
                + producer + ", guarantee=" + guarantee + ", color=" + color + ", season=" + season + ", fishingsetype="
                + fishingsetype + ", fishingnet=" + fishingnet + ", fishirods=" + fishirods + ", bait=" + bait
                + ", clothing=" + clothing + ", sex=" + sex + ", size=" + size + "\n";
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

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
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

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public FishingSetType getFishingsetype() {
        return fishingsetype;
    }

    public void setFishingsetype(FishingSetType fishingsetype) {
        this.fishingsetype = fishingsetype;
    }
    //

    public String getHeaders() {
        return "price" + "," + "name" + "," + "masa" + "," + "material" + "," + "guarantee" + "," + "color";
    }

    public String toCVS() {
        return String.valueOf(price + "," + name + "," + masa + "," + material + "," + guarantee + "," + color);
    }
}
