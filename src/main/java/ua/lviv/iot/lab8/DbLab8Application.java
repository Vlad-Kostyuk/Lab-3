package ua.lviv.iot.lab8;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ua.lviv.iot.model.FishingSetType;
import ua.lviv.iot.model.FishingShop;
import ua.lviv.iot.model.Producer;
import ua.lviv.iot.model.Season;


@SpringBootApplication
public class DbLab8Application {

    FishingShop fishingShop;

    final double priseNet = 1251;
    final String nameNet = "сітка";
    final double massNet = 1;
    final String materialNet = "металеві прути";
    final int guaranteeNet = 12;
    final String colorNet = "black";


    
    public static void main(String[] args) {
        SpringApplication.run(DbLab8Application.class, args);
    }

    @Bean
    public CommandLineRunner products(FishingShopRepository repository) {
        return (args) -> {
            repository.save(new FishingShopDb(priseNet, nameNet , massNet, materialNet, guaranteeNet,
                    colorNet)); 


            
            repository.findAll().forEach(fishingshopdb -> System.out.println(fishingshopdb));
        };
        
        
    }
}
