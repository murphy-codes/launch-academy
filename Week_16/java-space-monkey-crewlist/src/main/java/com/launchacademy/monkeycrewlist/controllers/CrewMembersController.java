package com.launchacademy.monkeycrewlist.controllers;

import com.launchacademy.monkeycrewlist.models.CrewMember;
import com.launchacademy.monkeycrewlist.repositories.CrewMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/crewmembers")
public class CrewMembersController {

  @Autowired
  CrewMemberRepository repository;

  @GetMapping
  public String getCrewMembers(Model model) {
    model.addAttribute("crewmembers", repository.findAll());
    return "crewmembers/index";
  }
}
