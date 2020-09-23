package com.launchacademy.teamrosterwithspring.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/positions")
public class PositionsController {
  @GetMapping
  public String getIndex(Model model) {
    return "positions/index";
  }

  @GetMapping("/{name}")
  public String getShow(Model model) {
    return "positions/show";
  }
}
