package ua.lviv.iot.shop.managers;

import java.util.ArrayList;
import java.util.Comparator;
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

    public List<FishingShop> searchByPrice(double price) {
        return  fishing.stream().filter(fishing -> fishing.getPrice() == price).collect(Collectors.toList());
       
    }

    public List<FishingShop> sortByPriceUpDown(boolean sortPrice) {
        if (sortPrice) {
            fishing.sort((o1, o2) -> (int) o1.getPrice() - (int) o2.getPrice());
        } else {
            fishing.sort((o1, o2) -> (int) o2.getPrice() - (int) o1.getPrice());
        }
        return fishing;
    }

    public List<FishingShop> sortByNameUpDown(boolean sortName) {
        if (sortName) {
            fishing.sort(Comparator.comparing(FishingShop::getName));
        } else {
            fishing.sort(Comparator.comparing(FishingShop::getName, (s1, s2) -> {
                return s2.compareTo(s1);
            }));

        }
        return fishing;
    }

    public List<FishingShop> searchBySeason(Season season) {
        return fishing.stream().filter(fishing -> fishing.getSeason() == season).collect(Collectors.toList());
    }

    public List<FishingShop> sortBySeasonUpDown(boolean sortSeason) {
        if (sortSeason) {
            fishing.sort(Comparator.comparing(FishingShop::getSeason));
        } else {
            fishing.sort(Comparator.comparing(FishingShop::getSeason, (s1, s2) -> {
                return s2.compareTo(s1);
            }));

        }
        return fishing;
    }

    public List<FishingShop> searchByProducer(Producer producer) {
        return fishing.stream().filter(fishing -> fishing.getProducer() == producer).collect(Collectors.toList());
    }

    public List<FishingShop> sortByProducerUpDown(boolean sortSeason) {

        if (sortSeason) {
            fishing.sort(Comparator.comparing(FishingShop::getProducer, (s1, s2) -> {
                return s2.compareTo(s1);
            }));
        } else {
            fishing.sort(Comparator.comparing(FishingShop::getProducer));
        }
        return fishing;
    }

    public List<FishingShop> searchByFishingSetType(FishingSetType fishingsettype) {
        return fishing.stream().filter(fishing -> fishing.getFishingsetype() == fishingsettype)
                .collect(Collectors.toList());
    }

    public List<FishingShop> sortByFishingSetTypeUpDown(boolean sortAscending) {

        if (sortAscending) {
            fishing.sort(Comparator.comparing(FishingShop::getFishingsetype, (s1, s2) -> {
                return s2.compareTo(s1);
            }));
        } else {
            fishing.sort(Comparator.comparing(FishingShop::getFishingsetype));
        }
        return fishing;
    }

    public void addFishing(FishingShop fishingShop) {
        fishing.add(fishingShop);
    }

}