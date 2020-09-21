package com.launchacademy.javathymeleafexercise.controllers;

import com.launchacademy.javathymeleafexercise.models.Product;
import com.launchacademy.javathymeleafexercise.services.ProductSessionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductsController {
  @Autowired
  ProductSessionService service;

  @GetMapping
  public String listProducts(Model model){
    List<Product> products = service.getList();
    model.addAttribute("products", products);
    return "product/index";
  }
  @GetMapping("/{id}")
  public String showProducts(@PathVariable int id, Model model){
    List<Product> products = service.getList();
    Product product = products.get(id);
    model.addAttribute("product", product);
    return "product/show";
  }
  @GetMapping("/new")
  public String productForm(Model model){
    Product product = new Product();
    model.addAttribute("product", product);
    return "product/new";
  }
  @PostMapping
  public String addProduct(@ModelAttribute Product product, Model model){
    product.setId(service.getList().size());
    service.addToList(product);
    model.addAttribute(product);
    return "redirect:/products";
  }
}
