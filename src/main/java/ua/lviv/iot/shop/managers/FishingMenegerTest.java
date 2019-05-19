package ua.lviv.iot.shop.managers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.shop.model.FishingRods;
import ua.lviv.iot.shop.model.FishingSetType;
import ua.lviv.iot.shop.model.FishingShop;
import ua.lviv.iot.shop.model.Producer;
import ua.lviv.iot.shop.model.Season;

class FishingMenegerTest {

    private FishingMeneger fishingMeneger;

    private FishingShop fishing = new FishingShop();
    private FishingShop fishingNet = new FishingShop();
    private FishingShop fishingTwo = new FishingShop();
    FishingRods fishingRods = new FishingRods();
    FishingShopWriter fishingShopWriter = new FishingShopWriter();

    private List<FishingShop> fishingShop = new LinkedList<>();
    private List<FishingShop> fishingShopTest = new LinkedList<>();
    private List<FishingShop> fishingShopReturn = new LinkedList<>();

    final double priseFishing = 800;
    final double priseNet = 1250;
    final double priseFishingTwo = 900;

    @BeforeEach
    public void setUp() {

        fishingNet.setPrice(priseNet);
        fishingNet.setName("Rods");
        fishingNet.setSeason(Season.SUMMER);
        fishingNet.setProducer(Producer.ASIA);
        fishingNet.setFishingsetype(FishingSetType.BAIT);
        fishingShop.add(fishingNet);

        fishingRods.setPrice(priseFishing);
        fishingRods.setName("Net");
        fishingRods.setMaximumWeight(0.12);
        fishingRods.setLength(12.54);

        fishing.setPrice(priseFishing);
        fishing.setName("Net");
        fishing.setSeason(Season.WINTER);
        fishing.setProducer(Producer.EUROPE);
        fishing.setFishingsetype(FishingSetType.CLOTHING);
        fishingShop.add(fishing);

        fishingTwo.setPrice(priseFishingTwo);
        fishingTwo.setName("fishing rod");
        fishingTwo.setSeason(Season.ALL_SEASON);
        fishingTwo.setProducer(Producer.USA);
        fishingTwo.setFishingsetype(FishingSetType.FISHINGNET);
        fishingShop.add(fishingTwo);

        fishingMeneger = new FishingMeneger(fishingShop);

    }

    @Test
    void searchByPricetTest() {
        fishingShopTest.clear();
        fishingShopTest.add(fishingTwo);

        assertEquals(fishingShopTest, fishingMeneger.searchByPrice(priseFishingTwo));
    }

    @Test
    void sortByPriceUpDownTest() {

        fishingShopTest.clear();
        fishingShopTest.add(fishing);
        fishingShopTest.add(fishingTwo);
        fishingShopTest.add(fishingNet);

        assertEquals(fishingShopTest, fishingMeneger.sortByPriceUpDown(true));
    }

    @Test
    void sortByNameUpDownTest() {

        fishingShopTest.clear();
        fishingShopTest.add(fishingTwo);
        fishingShopTest.add(fishingNet);
        fishingShopTest.add(fishing);

        assertEquals(fishingShopTest, fishingMeneger.sortByNameUpDown(false));
    }

    @Test
    void searchBySeasonTest() {

        fishingShopTest.clear();
        fishingShopTest.add(fishingNet);

        assertEquals(fishingShopTest, fishingMeneger.searchBySeason(Season.SUMMER));
    }

    @Test
    void sortBySeasonUpDownTest() {

        fishingShopTest.clear();
        fishingShopTest.add(fishingTwo);
        fishingShopTest.add(fishingNet);
        fishingShopTest.add(fishing);

        assertEquals(fishingShopTest, fishingMeneger.sortBySeasonUpDown(false));
    }

    @Test
    void searchByProducerTest() {

        fishingShopTest.clear();
        fishingShopTest.add(fishingNet);

        assertEquals(fishingShopTest, fishingMeneger.searchByProducer(Producer.ASIA));
    }

    @Test
    void sortByProducerUpDownTest() {

        fishingShopTest.clear();
        fishingShopTest.add(fishingNet);
        fishingShopTest.add(fishing);
        fishingShopTest.add(fishingTwo);

        assertEquals(fishingShopTest, fishingMeneger.sortByProducerUpDown(true));
    }

    @Test
    void searchByFishingSetTypeTest() {

        fishingShopTest.clear();
        fishingShopTest.add(fishingTwo);

        assertEquals(fishingShopTest, fishingMeneger.searchByFishingSetType(FishingSetType.FISHINGNET));
    }

    @Test
    void sortByFishingSetTypeUpDownTest() {

        fishingShopTest.clear();
        fishingShopTest.add(fishingTwo);
        fishingShopTest.add(fishing);
        fishingShopTest.add(fishingNet);

        assertEquals(fishingShopTest, fishingMeneger.sortByFishingSetTypeUpDown(false));
    }

    @Test
    void wtiteToFileTest() {

        List<String> fishingObject = new ArrayList<String>();
        fishingObject.add(fishing.getHeaders());
        fishingObject.add(fishing.toCVS());
        fishingObject.add("\n");
        fishingObject.add(fishingRods.getHeaders());
        fishingObject.add(fishingRods.toCVS());
        fishingShopWriter.wtiteToFile(fishingObject);
    }

}
