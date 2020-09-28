package com.launchacademy.javaspringappcategories.seeders;

import com.launchacademy.javaspringappcategories.models.AppCategory;
import com.launchacademy.javaspringappcategories.repositories.AppCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class AppCategorySeeder implements CommandLineRunner {
  private AppCategoryRepository appCategoryRepository;

  @Autowired
  public AppCategorySeeder(AppCategoryRepository appCategoryRepository) { this.appCategoryRepository = appCategoryRepository; }

  @Override
  public void run(String... args) throws Exception {
    List<String> seedList = Arrays.asList("Social Media", "Productivity", "Games", "Self Help");

    for(String name : seedList) {
      List appCategories = appCategoryRepository.findAllByName(name);
      if(appCategories.size() == 0) {
        AppCategory appCategory = new AppCategory();
        appCategory.setName(name);
        appCategoryRepository.save(appCategory);
      }
    }

//    AppCategory appCategory = new AppCategory();
//    appCategory = appCategoryRepository.findByName("Social Media");
//    System.out.println("----------------------------------------------------------------------------------------------------");
//    System.out.println(appCategory.getName());
//    // ----------------------------------------------------------------------------------------------------
//    appCategory = appCategoryRepository.findAllByName("Productivity").get(0);
//    System.out.println("----------------------------------------------------------------------------------------------------");
//    System.out.println(appCategory.getName());
//    // ----------------------------------------------------------------------------------------------------
//    List<AppCategory> appCategorysTwo = appCategoryRepository.findByNameStartingWith("Gam");
//    System.out.println("----------------------------------------------------------------------------------------------------");
//    int index = 0;
//    for (AppCategory appCategoryTwo: appCategorysTwo) { System.out.println("[" + (index++) + "] " + appCategoryTwo.getName()); }
//    // ----------------------------------------------------------------------------------------------------
//    appCategorysTwo = new ArrayList<>();
//    appCategorysTwo = appCategoryRepository.findByNameContaining("Self");
//    System.out.println("----------------------------------------------------------------------------------------------------");
//    for (AppCategory appCategoryTwo: appCategorysTwo) { System.out.println("[" + (index++) + "] " + appCategoryTwo.getName()); }
//    // ----------------------------------------------------------------------------------------------------
//    System.out.println("----------------------------------------------------------------------------------------------------");
  }
}
