package ua.lviv.iot.shop.managers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.shop.model.FishingSetType;
import ua.lviv.iot.shop.model.FishingShop;
import ua.lviv.iot.shop.model.Producer;
import ua.lviv.iot.shop.model.Season;

class FishingMenegerTest {

    private FishingMeneger fishingMeneger;

    private FishingShop fishing = new FishingShop();
    private FishingShop fishingNet = new FishingShop();
    private FishingShop fishingTwo = new FishingShop();

    private List<FishingShop> fishingShop = new LinkedList<>();
    private List<FishingShop> fishingShopTest = new LinkedList<>();

    final double priseFishing = 800;
    final double priseNet = 1250;
    final double priseFishingTwo = 900;

    @BeforeEach
    public void setUp() {

        fishingNet.setPrice(priseNet);
        fishingNet.setSeason(Season.SUMMER);
        fishingNet.setProducer(Producer.ASIA);
        fishingNet.setFishingsetype(FishingSetType.BAIT);
        fishingShop.add(fishingNet);

        fishing.setPrice(priseFishing);
        fishing.setSeason(Season.WINTER);
        fishing.setProducer(Producer.EUROPE);
        fishing.setFishingsetype(FishingSetType.CLOTHING);
        fishingShop.add(fishing);

        fishingTwo.setPrice(priseFishingTwo);
        fishingTwo.setSeason(Season.ALL_SEASON);
        fishingTwo.setProducer(Producer.USA);
        fishingTwo.setFishingsetype(FishingSetType.FISHINGNET);
        fishingShop.add(fishingTwo);

        fishingMeneger = new FishingMeneger(fishingShop);

    }

    @Test
    void sortByPriceTest() {

        fishingShopTest.add(fishing);
        fishingShopTest.add(fishingTwo);
        fishingShopTest.add(fishingNet);

        assertEquals(fishingShopTest, fishingMeneger.sortByPrice(fishingShop));
    }

    @Test
    void searchBySeasonTest() {

        fishingShopTest.clear();
        fishingShopTest.add(fishingNet);

        assertEquals(fishingShopTest, fishingMeneger.searchBySeason(Season.SUMMER));
    }
    
    @Test
    void searchByPricetTest() {
        
        fishingShopTest.clear();
        fishingShopTest.add(fishingTwo);
        
        assertEquals(fishingShopTest, fishingMeneger.searchByPrice(priseFishingTwo));
    }
    
    @Test
    void searchByProducerTest() {
        
        fishingShopTest.clear();
        fishingShopTest.add(fishingNet);
        
        assertEquals(fishingShopTest, fishingMeneger.searchByProducer(Producer.ASIA));
    }
    
    @Test
    void searchByFishingSetTypeTest() {
        
        fishingShopTest.clear();
        fishingShopTest.add(fishingTwo);
        
        assertEquals(fishingShopTest, fishingMeneger.searchByFishingSetType(FishingSetType.FISHINGNET));
    }
}
