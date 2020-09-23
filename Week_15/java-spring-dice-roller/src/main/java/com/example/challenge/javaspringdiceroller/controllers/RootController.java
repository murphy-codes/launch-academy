package com.launchacademy.webGreeter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/")
public class RootController {
  @GetMapping("/")
  public String showIndex(Model model) { return "index"; }
}