package ua.lviv.iot.lab8;

import org.springframework.data.repository.CrudRepository;

import ua.lviv.iot.model.FishingShop;



public interface FishingShopRepository 
    extends CrudRepository<FishingShopDb, Integer> {

}
