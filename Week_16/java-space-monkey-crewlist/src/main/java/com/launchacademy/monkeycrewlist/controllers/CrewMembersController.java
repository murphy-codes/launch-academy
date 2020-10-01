package com.launchacademy.monkeycrewlist.controllers;

import com.launchacademy.monkeycrewlist.models.CrewMember;
import com.launchacademy.monkeycrewlist.repositories.CrewMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@Controller
@RequestMapping("/crewmembers")
public class CrewMembersController {
  @Autowired
  CrewMemberRepository repository;

  @GetMapping
  public String getCrewMembers(Model model) {
    model.addAttribute("crewMembers", repository.findAll());
    return "crewmembers/index";
  }

  @GetMapping("/new")
  public String getNew(@ModelAttribute CrewMember crewMember) { return "crewmembers/new"; }

  @PostMapping
  public String addCrewMember(@ModelAttribute @Valid CrewMember crewMember, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) { return "crewmembers/new"; }
    else {
      repository.save(crewMember);
      return "redirect:/crewmembers";
    }
  }
}
