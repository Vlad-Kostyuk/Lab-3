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

    public static void main(String[] args) {

        final int lengthFishingRod = 3;

        final double priseFishingRod = 1200;
        final double priseNet = 1250;
        final double priseFishingRodTwo = 900;
        final double priseClothing = 800;
        final double priseFishingRodThree = 1700;

        final String nameFishingRod = "вудка";
        final String nameNet = "с≥тка";
        final String nameFishingRodTwo = "вудка";
        final String nameClothing = "од€г";
        final String nameFishingRodThree = "вудка";

        final double massFishingRod = 0.2;
        final double massNet = 1;
        final double massFishingRodTwo = 0.2;
        final double massClothing = 0.2;
        final double massFishingRodThree = 0.2;

        final String materialFishingRod = "пласмаса";
        final String materialNet = "металев≥ прути";
        final String materialFishingRodTwo = "пласмаса";
        final String materialClothing = "тканина";
        final String materialFishingRodThree = "пласмаса";

        final int guaranteeFishingRod = 12;
        final int guaranteeNet = 12;
        final int guaranteeFishingRodTwo = 12;
        final int guaranteeClothing = 12;
        final int guaranteeFishingRodThree = 24;

        final String colorFishingRod = "green";
        final String colorNet = "black";
        final String colorFishingRodTwo = "green";
        final String colorClothing = "white";
        final String colorFishingRodThree = "green";

        final int maximumWeightFishingRod = 2;
        final int maximumWeightFishingRodTwo = 3;

        final String formFishingRod = "prama";

        List<FishingShop> fishing = new ArrayList<>();

        fishing.add(new FishingShop(priseFishingRod, nameFishingRod, massFishingRod, materialFishingRod,
                Producer.USA, guaranteeFishingRod, colorFishingRod, Season.SUMMER, FishingSetType.FISHINGNET));

        fishing.add(new FishingShop(priseNet, nameNet, massNet, materialNet, Producer.EUROPE, guaranteeNet,
                colorNet, Season.ALL_SEASON, FishingSetType.BAIT));

        fishing.add(new Bait(priseFishingRodTwo, nameFishingRodTwo, massFishingRodTwo,
                materialFishingRodTwo,  Producer.USA, guaranteeFishingRodTwo, colorFishingRodTwo, Season.SUMMER,
                FishingSetType.FISHINGNET, maximumWeightFishingRod));

        fishing.add(new Clothing(priseClothing, nameClothing, massClothing, materialClothing, Producer.EUROPE,
                guaranteeClothing, colorClothing, Season.SUMMER, FishingSetType.CLOTHING, Sex.FEMALE, Size.L));

        fishing.add(new FishingNet(priseFishingRodThree, nameFishingRodThree, massFishingRodThree,
                materialFishingRodThree, Producer.USA, guaranteeFishingRodThree, colorFishingRodThree,
                Season.SUMMER, FishingSetType.FISHINGNET, maximumWeightFishingRodTwo, lengthFishingRod,
                formFishingRod));
        

        FishingMeneger database = new FishingMeneger(fishing);

        List<FishingShop> sortedFishing = (new FishingMeneger(fishing)).sortByPrice(fishing);
        System.out.println(sortedFishing);

        fishing.sort(Comparator.comparing(FishingShop::getName));
        System.out.println(fishing);

        List<FishingShop> searchByPrice = database.searchByPrice(priseClothing);
        System.out.println(searchByPrice);

        List<FishingShop> searchBySeason = database.searchBySeason(Season.ALL_SEASON);
        System.out.println(searchBySeason);

        List<FishingShop> searchByProducer = database.searchByProducer(Producer.USA);
        System.out.println(searchByProducer);

        List<FishingShop> searchByFishingSetType = database.searchByFishingSetType(FishingSetType.BAIT);
        System.out.println(searchByFishingSetType);
    }

}
