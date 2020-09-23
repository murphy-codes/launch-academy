package com.launchacademy.teamrosterwithspring.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/")
public class LeagueController {
  @GetMapping("/")
  public RedirectView redirectWithUsingRedirectView() { return new RedirectView("/teams"); }
//  public RedirectView redirectWithUsingRedirectView() { return new RedirectView("/league"); }
//
//  @GetMapping("/league")
//  public String getIndex(Model model) {
//    return "league/index";
//  }
}
