package ua.lviv.iot.shop.managers;

import java.util.ArrayList;
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
import java.util.Comparator;

public class FishingMain {

	public static void main(String[] args) {

		List<FishingShop> fishing = new ArrayList<>();

		fishing.add(new FishingShop(1200, "вудка", 0.2, "пласмаса", Producer.USA, 12, "зелений", Season.SUMMER,
				FishingSetType.FISHINGNET));
		fishing.add(new FishingShop(1250, "сітка", 1, "металеві прути", Producer.EUROPE, 12, "black", Season.ALL_SEASON,
				FishingSetType.BAIT));
		fishing.add(new Bait(900, "вудка", 0.2, "пласмаса", Producer.USA, 123, "зелений", Season.SUMMER,
				FishingSetType.FISHINGNET, 2));
		fishing.add(new Clothing(800, "одяг", 0.2, "тканина", Producer.EUROPE, 12, "white", Season.SUMMER,
				FishingSetType.CLOTHING, Sex.FEMALE, Size.L));
		fishing.add(new FishingNet(1700, "вудка", 0.2, "пласмаса", Producer.USA, 24, "зелений", Season.SUMMER,
				FishingSetType.FISHINGNET, 2, 3, "Prama"));

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
