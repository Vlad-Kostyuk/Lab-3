package ua.lviv.iot.shop.managers;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import ua.lviv.iot.shop.model.Bait;
import ua.lviv.iot.shop.model.Clothing;
import ua.lviv.iot.shop.model.FishingNet;
import ua.lviv.iot.shop.model.FishingSetType;
import ua.lviv.iot.shop.model.FishingShop;
import ua.lviv.iot.shop.model.Producer;
import ua.lviv.iot.shop.model.Season;
import ua.lviv.iot.shop.model.Sex;
import ua.lviv.iot.shop.model.Size;

public class FishingMain {

    public final static  int LENGTH_FISHING_ROD = 3;

    public final static double PRISE_FISHING_ROD = 1200;
    public final static double PRISE_NET = 1250;
    public final static double PRISE_FISHING_ROD_TWO = 900;
    public final static double PRISE_CLOTHING = 800;
    public final static double PRISE_FISHING_ROD_THREE = 1700;

    public final static String NAME_FISHING_ROD = "вудка";
    public final static String NAME_NET = "с≥тка";
    public final static String NAME_FISHING_ROD_TWO = "вудка";
    public final static String NAME_CLOTHING = "од€г";
    public final static String NAME_FISHING_ROD_THREE = "вудка";

    public final static double MASS_FISHING_ROD = 0.2;
    public final static double MASS_NET = 1;
    public final static double MASS_FISHING_ROD_TWO = 0.2;
    public final static double MASS_CLOTHING = 0.2;
    public final static double MASS_FISHING_ROD_THREE = 0.2;

    public final static String MATERIAL_FISHING_ROD = "пласмаса";
    public final static String MATERIAL_NET = "металев≥ прути";
    public final static String MATERIAL_FISHING_ROD_TWO = "пласмаса";
    public final static String MATERIAL_CLOTHING = "тканина";
    public final static String MATERIAL_FISHING_ROD_THREE = "пласмаса";

    public final static int GUARANTEE_FISHING_ROD = 12;
    public final static int GUARANTEE_NET = 12;
    public final static int GUARANTEE_FISHING_ROD_TWO = 12;
    public final static int GUARANTEE_CLOTHING = 12;
    public final static int GUARANTEE_FISHING_ROD_THREE = 24;

    public final static String COLOR_FISHING_ROD = "green";
    public final static String COLOR_NET = "black";
    public final static String COLOR_FISHING_ROD_TWO = "green";
    public final static String COLOR_CLOTHING = "white";
    public final static String COLOR_FISHING_ROD_THREE = "green";

    public final static int MAXIMUMWEIGHT_FISHING_ROD = 2;
    public final static int MAXIMUMWEIGHT_FISHING_ROD_TWO = 3;

    public final static String FORM_FISHING_ROD = "Prama";

    public static void main(String[] args) {

        List<FishingShop> fishing = new ArrayList<>();

        fishing.add(new FishingShop(PRISE_FISHING_ROD, NAME_FISHING_ROD, MASS_FISHING_ROD, MATERIAL_FISHING_ROD,
                Producer.USA, GUARANTEE_FISHING_ROD, COLOR_FISHING_ROD, Season.SUMMER, FishingSetType.FISHINGNET));

        fishing.add(new FishingShop(PRISE_NET, NAME_NET, MASS_NET, MATERIAL_NET, Producer.EUROPE, GUARANTEE_NET,
                COLOR_NET, Season.ALL_SEASON, FishingSetType.BAIT));

        fishing.add(new Bait(PRISE_FISHING_ROD_TWO, NAME_FISHING_ROD_TWO, MASS_FISHING_ROD_TWO,
                MATERIAL_FISHING_ROD_TWO, Producer.USA, GUARANTEE_FISHING_ROD_TWO, COLOR_FISHING_ROD_TWO, Season.SUMMER,
                FishingSetType.FISHINGNET, MAXIMUMWEIGHT_FISHING_ROD));

        fishing.add(new Clothing(PRISE_CLOTHING, NAME_CLOTHING, MASS_CLOTHING, MATERIAL_CLOTHING, Producer.EUROPE,
                GUARANTEE_CLOTHING, COLOR_CLOTHING, Season.SUMMER, FishingSetType.CLOTHING, Sex.FEMALE, Size.L));

        fishing.add(new FishingNet(PRISE_FISHING_ROD_THREE, NAME_FISHING_ROD_THREE, MASS_FISHING_ROD_THREE,
                MATERIAL_FISHING_ROD_THREE, Producer.USA, GUARANTEE_FISHING_ROD_THREE, COLOR_FISHING_ROD_THREE,
                Season.SUMMER, FishingSetType.FISHINGNET, MAXIMUMWEIGHT_FISHING_ROD_TWO, LENGTH_FISHING_ROD,
                FORM_FISHING_ROD));

        FishingMeneger database = new FishingMeneger(fishing);

        List<FishingShop> sortedFishing = (new FishingMeneger(fishing)).sortByPrice(fishing);
        System.out.println(sortedFishing);

        fishing.sort(Comparator.comparing(FishingShop::getName));
        System.out.println(fishing);

        List<FishingShop> searchByPrice = database.searchByPrice(800);
        System.out.println(searchByPrice);

        List<FishingShop> searchBySeason = database.searchBySeason(Season.ALL_SEASON);
        System.out.println(searchBySeason);

        List<FishingShop> searchByProducer = database.searchByProducer(Producer.USA);
        System.out.println(searchByProducer);

        List<FishingShop> searchByFishingSetType = database.searchByFishingSetType(FishingSetType.BAIT);
        System.out.println(searchByFishingSetType);
    }

}
