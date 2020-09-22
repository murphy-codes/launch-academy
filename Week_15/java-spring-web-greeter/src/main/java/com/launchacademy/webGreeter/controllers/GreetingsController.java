package com.launchacademy.webGreeter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/greetings")
public class GreetingsController {

  @GetMapping("/default")
  public String getDefaultGreeting(Model model) {
    model.addAttribute("greeting", "Hello from Spring");
    return "greetings/show";
  }

  @GetMapping("/by-query-string")
      public String getQueryStringGreeting(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName, Model model) {
    model.addAttribute("greeting", "Hello from Spring" + (firstName == null ? "" : ", " + firstName + (lastName == null ? "" : " " + lastName)));
    return "greetings/show";
  }

  @GetMapping("/by-name/{name}")
  public String getCustomizedGreeting(@PathVariable String name, Model model) {
    model.addAttribute("greeting", "Hello from Spring, " + name);
    return "greetings/show";
  }

  @GetMapping("/by-language/{lang}")
  public String byLanguageGreeting(@PathVariable(required = false) String lang, Model model) {
    Map<String,String> langMap = Map.of("en", "Hello", "es", "Hola", "fr", "Bonjour");
    model.addAttribute("greeting", (langMap.containsKey(lang) ? langMap.get(lang) : "Hi") + " from Spring");
    return "greetings/show";
  }
}