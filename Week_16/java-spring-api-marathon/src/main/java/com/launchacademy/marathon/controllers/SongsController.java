package com.launchacademy.marathon.controllers;

import com.launchacademy.marathon.models.Song;
import com.launchacademy.marathon.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongsController {
  private SongRepository songRepository; //@Autowired

  @Autowired
  public SongsController(SongRepository songRepository) { this.songRepository = songRepository; }

  @GetMapping
  public String getIndex(Model model) {
    List<Song> songs = (List<Song>) songRepository.findAll();
    model.addAttribute("songs", songs);
    return "songs/index";
  }

  @GetMapping("/new")
  public String getNew(@ModelAttribute Song song) { return "songs/new"; }

  @PostMapping
  public String addSong(@ModelAttribute @Valid Song song, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) { return "songs/new"; }
    else {
      songRepository.save(song);
      return "redirect:/songs";
    }
  }
}