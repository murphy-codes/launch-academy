package com.launchacademy.mallmadness.seeders;

import com.launchacademy.mallmadness.models.Store;
import com.launchacademy.mallmadness.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class StoreSeeder implements CommandLineRunner {
  @Autowired private StoreRepository storeRepository;

  @Override
  public void run(String... args) throws Exception {
    List<Store> stores = new ArrayList<>();
    Store store = new Store();

    store.setName("Launch Discount");
    store.setType("Fashion Boutique");
    store.setAverageCost(1);
    store.setOperatingStatus(true);
    stores.add(store);
    store = new Store();
    store.setName("Launch Fashion");
    store.setType("Clothing Store");
    store.setAverageCost(3);
    store.setOperatingStatus(true);
    stores.add(store);
    store = new Store();
    store.setName("Launch Aesthetic");
    store.setType("Designer Fashion");
    store.setAverageCost(5);
    store.setOperatingStatus(true);
    stores.add(store);
    store = new Store();
    store.setName("Toys 'R Us");
    store.setType("Toy Store");
    store.setAverageCost(3);
    store.setOperatingStatus(false);
    stores.add(store);
    store = new Store();
    store.setName("Filene's Basement");
    store.setType("Department Store");
    store.setAverageCost(2);
    store.setOperatingStatus(false);
    stores.add(store);
    store = new Store();
    store.setName("Borders");
    store.setType("Book Store");
    store.setAverageCost(3);
    store.setOperatingStatus(false);
    stores.add(store);

    for(Store newStore : stores) { if(!storeRepository.existsByName(newStore.getName())) { storeRepository.save(newStore); } }
  }
}
