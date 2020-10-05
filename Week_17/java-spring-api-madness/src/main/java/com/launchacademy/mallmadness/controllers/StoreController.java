package com.launchacademy.mallmadness.controllers;

import com.google.inject.internal.util.Lists;
import com.launchacademy.mallmadness.models.Store;
import com.launchacademy.mallmadness.repositories.StoreRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stores")
public class StoreController {
  @Autowired private StoreRepository storeRepository;

  @GetMapping
  public String getIndex(Model model) {
    model.addAttribute("stores", Lists.newArrayList(storeRepository.findAll()));
    return "stores/index";
  }

  @GetMapping("/new")
  public String getNew(@ModelAttribute Store store, Model model) { return "stores/new"; }

  @PostMapping
  private String getPost(@ModelAttribute @Valid Store store, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) { return "stores/new"; }
    else {
      storeRepository.save(store);
      return "redirect:/stores";
    }
  }
}
