package com.launchacademy.partyplanner.controllers;

import com.launchacademy.partyplanner.models.Party;
import com.launchacademy.partyplanner.repositories.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequestMapping("/parties")
public class PartiesController {
  @Autowired private PartyRepository partyRepository;

  @GetMapping
  public String getIndex(Model model) {
//    List<Party> parties = (List<Party>) partyRepository.findAll();
    model.addAttribute("parties", (List<Party>) partyRepository.findAll());
    return "parties/index";
  }

  @GetMapping("/{partyName}")
  public String getShow(@PathVariable String partyName, Model model) {
    Party party = partyRepository.findFirstByName(partyName);
    model.addAttribute("party", party);
    return "positions/show";
  }

  @GetMapping("/new")
  public String getNew(@ModelAttribute Party party) { return "fantasy/teams/new"; }

  @PostMapping
  public String addParty(@ModelAttribute Party party) {
    partyRepository.save(party);
    return "redirect:/parties/" + (party.getName());
  }
}
