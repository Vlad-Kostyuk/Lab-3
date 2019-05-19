package ua.lviv.iot.shop.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import ua.lviv.iot.shop.model.FishingSetType;
import ua.lviv.iot.shop.model.FishingShop;
import ua.lviv.iot.shop.model.Producer;
import ua.lviv.iot.shop.model.Season;

public class FishingMeneger {

	private List<FishingShop> fishing = new ArrayList<>();

	public FishingMeneger() {

	}

	public FishingMeneger(List<FishingShop> fishing) {
		this.fishing = fishing;
	}

	public List<FishingShop> getFishing() {
		return fishing;
	}

	public void setFishing(List<FishingShop> fishing) {
		this.fishing = fishing;
	}

	public List<FishingShop> sortByPrice(List<FishingShop> fishingshop) {
		fishingshop.sort((o1, o2) -> (int) o1.getPrice() - (int) o2.getPrice());
		return fishingshop;
	}

	public List<FishingShop> searchBySeason(Season season) {
		List<FishingShop> fishingList = fishing;
		List<FishingShop> filteredFishingList = fishingList.stream().filter(fishing -> fishing.getSeason() == season)
				.collect(Collectors.toList());
		return filteredFishingList;
	}

	public List<FishingShop> searchByPrice(double price) {
		List<FishingShop> fishingList = fishing;
		List<FishingShop> filteredFishingList = fishingList.stream().filter(fishing -> fishing.getPrice() == price)
				.collect(Collectors.toList());
		return filteredFishingList;
	}

	public List<FishingShop> searchByProducer(Producer producer) {
		List<FishingShop> fishingList = fishing;
		List<FishingShop> filteredFishingList = fishingList.stream()
				.filter(fishing -> fishing.getProducer() == producer).collect(Collectors.toList());
		return filteredFishingList;
	}

	public List<FishingShop> searchByFishingSetType(FishingSetType fishingsettype) {
		List<FishingShop> fishingList = fishing;
		List<FishingShop> filteredFishingList = fishingList.stream()
				.filter(fishing -> fishing.getFishingsetype() == fishingsettype).collect(Collectors.toList());
		return filteredFishingList;
	}
}