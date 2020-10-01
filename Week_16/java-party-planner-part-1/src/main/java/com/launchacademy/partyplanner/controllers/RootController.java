package com.launchacademy.partyplanner.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/")
public class RootController {
  @GetMapping
  public RedirectView rootRedirect() { return new RedirectView("/parties"); }

  @GetMapping("/404")
  public String error404Redirect(Model model) {
    return "404";
  }
}