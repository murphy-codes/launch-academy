package com.launchacademy.mallmadness.controllers;

import com.launchacademy.mallmadness.dtos.StoreDTO;
import com.launchacademy.mallmadness.models.Store;
import com.launchacademy.mallmadness.repositories.StoreRepository;
import com.launchacademy.mallmadness.services.StoreService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stores")
public class StoresApiController {
  @Autowired private StoreRepository storeRepository;
  @Autowired private StoreService storeService;

  @GetMapping
  public Page<StoreDTO> getStores(@PageableDefault(size = 5, page = 0) Pageable pageable) {
    return storeService.findAll(pageable);
  }

  @NoArgsConstructor
  private class StoreNotFoundException extends RuntimeException {};

  @ControllerAdvice
  private class StoreNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(StoreNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String storeNotFoundHandler(StoreNotFoundException ex) { return ex.getMessage(); }
  }

  @GetMapping("/{id}")
  public Store getStoreById(@PathVariable Integer id) { return storeRepository.findById(id).orElseThrow(() -> new StoreNotFoundException()); }

  @PostMapping
  public Store createStore(@PathVariable Store store) { return storeRepository.save(store); }
}