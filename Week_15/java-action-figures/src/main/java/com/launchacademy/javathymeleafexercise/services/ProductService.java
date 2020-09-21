package com.launchacademy.javathymeleafexercise.services;

import com.launchacademy.javathymeleafexercise.models.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
  public List<Product> findAll() {
    List products = new ArrayList<Product>();
    Product product = new Product();

    product.setId(0);
    product.setName("GI Joe");
    product.setDescription("America's Favorite Action Figure");
    product.setPrice(4.99);
    products.add(product);


    product = new Product();
    product.setId(1);
    product.setName("Transformer");
    product.setDescription("More Than Meets the Eye");
    product.setPrice(26.49);
    products.add(product);

    product = new Product();
    product.setId(2);
    product.setName("Dr Who");
    product.setDescription("It's a Thymey Whymey Toy");
    product.setPrice(14.49);
    products.add(product);

    return products;
  }

  public Product get(Integer index) {
    return findAll().get(index);
  }
}
